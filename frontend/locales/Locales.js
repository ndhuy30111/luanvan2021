// user
import UserMsg from '~/locales/user/msg'
// admin
import AdminMsg from '~/locales/admin/msg'
import AdminMenu from '~/locales/admin/menu'
import AdminHeaderTable from '~/locales/admin/headerTable'
import ADMINCATEGORY from '~/locales/admin/category'
import AdminPorudct from '~/locales/admin/product'
import ADMINGENERAL from '~/locales/admin/general'
export default () => ({
  vn: UserMsg(),

  vn_admin: AdminMsg(),
  vn_admin_menu: AdminMenu(),
  vn_admin_headerTable: AdminHeaderTable(),
  vn_admin_product: AdminPorudct(),
  vn_admin_category: ADMINCATEGORY(),
  vn_admin_general: ADMINGENERAL(),
})
