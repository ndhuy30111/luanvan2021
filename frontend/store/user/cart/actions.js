import constants from './constants'

export default {
  async addCart({ commit }, cartItem) {
    const newCartitem = {
      productID: cartItem.id,
      quantity: cartItem.quantity,
      color: cartItem.color,
      size: cartItem.size,
    }
    try {
      const res = await this.$repositories.cartRepostory.addcart(newCartitem)
      const { status } = res
      if (status === 201) {
        commit(constants.MUTATIONS_CART_ADDTOCART, cartItem)
        this.$toast.global.cart()
      }
    } catch (e) {
      return false
    }
  },

  async showcart({ commit }) {
    const res = await this.$repositories.cartRepostory.showcart()
    const { status, data } = res
    if (status === 200) {
      commit(constants.MUTATIONS_SHOW_CART, data)
    }
  },
  async updateCart({ commit }, cart) {
    await this.$repositories.cartRepostory.updated(cart.idCart, cart)
  },
  async deleteCart({ commit }, item) {
    try {
      const res = await this.$repositories.cartRepostory.delete(item.idCart)
      const { status } = res
      if (status === 200) {
        commit(constants.MUTATIONS_REMOVE_PRODUCTCART, item)
      }
    } catch (e) {}
  },
  removeCart: (context) => {
    context.commit(constants.MUTATIONS_REMOVE_CART)
  },
  plus({ commit }, cartItems) {
    commit(constants.MUTATIONS_PLUS_ITEMCART, cartItems)
  },
  minus: (context, cartItems) => {
    context.commit(constants.MUTATIONS_MINUS_ITEMCART, cartItems)
  },
}
