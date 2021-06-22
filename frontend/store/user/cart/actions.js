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
        return true
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
      return true
    }
  },
  removeCart: (context) => {
    context.commit(constants.MUTATIONS_REMOVE_CART)
  },
  removeProductCart: (context, indexRemove) => {
    context.commit(constants.MUTATIONS_REMOVE_PRODUCTCART, indexRemove)
  },
  plus: (context, i) => {
    context.commit(constants.MUTATIONS_PLUS_ITEMCART, i)
  },
  minus: (context, i) => {
    context.commit(constants.MUTATIONS_MINUS_ITEMCART, i)
  },
}
