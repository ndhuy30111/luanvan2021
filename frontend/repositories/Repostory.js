// admin
import ProductAdminRepository from '~/repositories/admin/ProductRepostory'
import ColorAdminRepository from '~/repositories/admin/ColorRepostory'
export default ($axios) => ({
  // admin
  productAdmin: ProductAdminRepository($axios),
  colorAdmin: ColorAdminRepository($axios),
})
