// admin
import ProductAdminRepository from '~/repositories/admin/ProductRepostory'
import ColorAdminRepository from '~/repositories/admin/ColorRepostory'
import CategoryAdminRepository from '~/repositories/admin/CategoryRepostory'
import SizeAdminRepository from '~/repositories/admin/SizeRepostory'
import DetailsProductAdminRepository from '~/repositories/admin/DetailsProductRepostory'
import CouponAdminRepository from '~/repositories/admin/CouponRepostory'
import AuthAdminRepository from '~/repositories/admin/AuthRepostory'
// user
import AccounRepostory from '~/repositories/user/AccounRepostory'
import CategoryReponstory from '~/repositories/user/CategoryRepostory'
import ProductReponstory from '~/repositories/user/ProductRepostory'
export default ($axios) => ({
  // admin
  productAdmin: ProductAdminRepository($axios),
  colorAdmin: ColorAdminRepository($axios),
  categoryAdmin: CategoryAdminRepository($axios),
  sizeAdmin: SizeAdminRepository($axios),
  detailsproductAdmin: DetailsProductAdminRepository($axios),
  couponAdmin: CouponAdminRepository($axios),
  authAdmin: AuthAdminRepository($axios),
  // user
  account: AccounRepostory($axios),
  categoryUser: CategoryReponstory($axios),
  productUser: ProductReponstory($axios),
})
