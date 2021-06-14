import UserMsg from '~/locales/user/msg'
import AdminMsg from '~/locales/admin/msg'
import AdminMenu from '~/locales/admin/menu'
import AdminHeaderTable from '~/locales/admin/headerTable'
import AdminPorudct from '~/locales/admin/product'
export default () => ({
  vn: UserMsg(),
  vn_admin: AdminMsg(),
  vn_admin_menu: AdminMenu(),
  vn_admin_headerTable: AdminHeaderTable(),
  vn_admin_product: AdminPorudct(),
})
