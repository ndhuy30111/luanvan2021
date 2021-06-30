export default () => ({
  ACTIONS_CATEGORYS_GETALL: 'user/categorys/getAll',

  // Cart has Account
  ACTION_CART_ADDTOCART_USER: 'user/cart/addCartUser',
  ACTION_SHOW_CART_USER: 'user/cart/showcartUser',
  ACTION_REMOVE_CART_USER: 'user/cart/removeCartUser',
  ACTION_DELETE_PRODUCTCART_USER: 'user/cart/deleteCartUser',
  ACTION_UPDATE_CART_USER: 'user/cart/updateCartUser',
  ACTION_PLUS_ITEMCART_USER: 'user/cart/plusUser',
  ACTION_MINUS_ITEMCART_USER: 'user/cart/minusUser',

  // Cart hasn't Account
  ACTION_CART_ADDTOCART: 'user/cart/addCart',
  ACTION_SHOW_CART: 'user/cart/render',
  ACTION_REMOVE_CART: 'user/cart/removeProductCart',
  ACTION_PLUS_ITEMCART: 'user/cart/plus',
  ACTION_MINUS_ITEMCART: 'user/cart/minus',

  ACTIONS_USER_REGISTER: 'user/account/register',
  ACTIONS_USER_LOGINFACEBOOK: 'user/account/loginFacebook',
  ACTIONS_USER_REGISTERFACEBOOk: 'user/account/registerFacebook',
  ACTIONS_USER_UPDATE: 'user/account/update',

  ACTIONS_PRODUCT_GETALL: 'user/product/getAll',

  ACTIONS_SEARCH: 'user/search/getSearch',

  ACTION_CHECKOUT_SETPRODUCT: 'user/checkout/setProdcut',
  ACTION_REMOVE_PRODUCTCART_CHECKOUT: 'user/checkout/removeProduct',

  ACTION_POST_REVIEW: 'user/review/postCommit',
})
