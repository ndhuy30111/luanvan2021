export default () => ({
  // ===Category===
  /*
    Muatation Category
  */
  MUTATION_ADMIN_INIT: 'INIT',
  MUTATION_ADMIN_CATEGORY_SET_CONTENT: 'MUTATION_ADMIN_CATEGORY_SET_CONTENT',
  MUTATION_ADMIN_CATEGORY_ADD_CONTENT: 'MUTATION_ADMIN_CATEGORY_ADD_CONTENT',
  MUTATION_ADMIN_CATEGORY_UPDATE_CONTENT:
    'MUTATION_ADMIN_CATEGORY_UPDATE_CONTENT',
  MUTATION_ADMIN_CATEGORY_DELETE_CONTENT:
    'MUTATION_ADMIN_CATEGORY_DELETE_CONTENT',
  /*
    Action Category
  */
  ACTION_ADMIN_CATEGORY_INIT: 'admin/category/init',
  ACTION_ADMIN_CATEGORY_ADD: 'admin/category/addCategory',
  ACTION_ADMIN_CATEGORY_UPDATA: 'admin/category/updataCategory',
  ACTION_ADMIN_CATEGORY_DELETE: 'admin/category/deleteCategory',
  /*
    Getter Setter Category
  */
  GETTER_ADMIN_CATEGORY_GETALL: 'admin/category/getFindAll',
  GETTER_ADMIN_CATEGORY_GETBYCATEGORYNULL:
    'admin/category/getFindByCategoryNull',
  //  Product
  ACTION_ADMIN_PRODUCT_INIT: 'admin/product/init',
  ACTION_ADMIN_PRODUCT_ADD: 'admin/product/addProduct',
  ACTION_ADMIN_PRODUCT_UPDATE: 'admin/product/updateProduct',
  ACTION_ADMIN_PRODUCT_SHOW: 'admin/product/showProduct',
  ACTION_ADMIN_PRODUCT_DELETE: 'admin/product/deleteProduct',
  MUTATION_ADMIN_PRODUCT_INIT: 'MUTATION_ADMIN_PRODUCT_INIT',
  MUTATION_ADMIN_PRODUCT_ADD: 'MUTATION_ADMIN_PRODUCT_ADD',
  MUTATION_ADMIN_PRODUCT_UPDATE: 'MUTATION_ADMIN_PRODUCT_UPDATE',
  MUTATION_ADMIN_PRODUCT_DELETE: 'MUTATION_ADMIN_PRODUCT_DELETE',
  // Color
  ACTION_ADMIN_COLOR_INIT: 'admin/color/init',
  ACTION_ADMIN_COLOR_ADD: 'admin/color/addColor',
  ACTION_ADMIN_COLOR_UPDATA: 'admin/color/updateColor',
  ACTION_ADMIN_COLOR_DELETE: 'admin/color/deleteColor',
  MUTATION_ADMIN_COLOR_INIT: 'MUTATION_ADMIN_COLOR_INIT',
  MUTATION_ADMIN_COLOR_ADD: 'MUTATION_ADMIN_COLOR_ADD',
  MUTATION_ADMIN_COLOR_UPDATE: 'MUTATION_ADMIN_COLOR_UPDATE',
  MUTATION_ADMIN_COLOR_DELETE: 'MUTATION_ADMIN_COLOR_DELETE',
  // Details Product
  ACTION_ADMIN_DETAILS_PRODUCT_ADD: 'admin/detailsproduct/addDetailsproduct',
  // Size

  ACTION_ADMIN_SIZE_ADD: 'admin/size/addSize',
  ACTION_ADMIN_SIZE_UPDATE: 'admin/size/updateAmount',
  ACTION_ADMIN_SIZE_DELETE: 'admin/size/deleteSize',
  MUTATION_ADMIN_SIZE_ADD: 'MUTATION_ADMIN_SIZE_ADD',

  // Auth
  ACTION_ADMIN_LOGIN: 'admin/auth/login',
  ACTION_ADMIN_USER: 'admin/auth/user',
  ACTION_ADMIN_IMAGE_ADDIMAGE: 'admin/image/addImage',
  // COUPON
  ACTION_ADMIN_COUPON_INIT: 'admin/coupon/init',
  ACTION_ADMIN_COUPON_DELETE: 'admin/coupon/delete',
  MUTATION_ADMIN_COUPON_INIT: 'MUTATION_ADMIN_COUPON_INIT',
  MUTATION_ADMIN_COUPON_UPDATE: 'MUTATION_ADMIN_COUPON_UPDATE',
  // INVOICE
  ACTION_ADMIN_INVOICE_INIT: 'admin/invoice/init',
  MUTATION_ADMIN_INVOICE_INIT: 'MUTATION_ADMIN_INVOICE_INIT',
})
