import constants from './constants'

export default {
  addProdcutToCart: (context, cartItem) => {
    context.commit(constants.MUTATIONS_CART_ADDTOCART, cartItem)
  },
}
