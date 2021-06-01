// admin
import ProductAdminRepository from '~/repositories/admin/ProductRepostory'
import ColorAdminRepository from '~/repositories/admin/ColorRepostory'
import CategoryAdminRepository from '~/repositories/admin/CategoryRepostory'
import AccounRepostory from '~/repositories/user/AccounRepostory'
export default ($axios) => ({
  // admin
  productAdmin: ProductAdminRepository($axios),
  colorAdmin: ColorAdminRepository($axios),
  categoryAdmin: CategoryAdminRepository($axios),
  account: AccounRepostory($axios),
})
