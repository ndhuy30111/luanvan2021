// admin
import ProductAdminRepository from '~/repositories/admin/ProductRepostory'
import ColorAdminRepository from '~/repositories/admin/ColorRepostory'
import CategoryAdminRepository from '~/repositories/admin/CategoryRepostory'
import AccounRepostory from '~/repositories/user/AccounRepostory'
import CategoryReponstory from '~/repositories/user/CategoryReponstory'
export default ($axios) => ({
  // admin
  productAdmin: ProductAdminRepository($axios),
  colorAdmin: ColorAdminRepository($axios),
  categoryAdmin: CategoryAdminRepository($axios),

  // user
  account: AccounRepostory($axios),
  categoryUser: CategoryReponstory($axios),
})
