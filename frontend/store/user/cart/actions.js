import constants from './constants'

export default {
  addProdcutToCart: (context, cartItem) => {
    context.commit(constants.ACTIONS_CART_ADDTOCART, cartItem)
  },
}
