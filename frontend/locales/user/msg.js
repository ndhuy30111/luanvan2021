export default () => ({
  nation: 'Việt Nam',
  shop: 'Shop 7755',
  sreach: 'Tìm kiếm',
  menuproduct: ['ÁO THUN', 'VÁY', 'QUẦN JEAN'],
  title_news: 'Top sản phẩm bán chạy trong tháng',
  tilte_page_product: ['TẤT CẢ SẢN PHẨM'],
  shopnow: 'Mua sắm ngay',
  title_carousel_woman: 'TRÃI NGHIỆM OUTFITS MỚI',
  title_carousel_man: 'NĂNG ĐỘNG VÀ THANH LỊCH',
  menuoption: ['MÔ TẢ', 'BÌNH LUẬN'],
  comments: 'Đăng',
  facebook_mes: 'Plugin bình luận trên facebook',
  same_product: ['Sản phẩm cùng loại'],
  color: 'Màu sắc',
  size: 'Kích cỡ',
  quantity: 'Số lượng',
  add_cart: 'Thêm vào giỏ',
  menu_header: [
    {
      content: 'Trang chủ',
      url: '/',
      active: true,
    },
    {
      content: 'Sản phẩm',
      url: 'shop',
      active: false,
    },
    {
      content: 'Liên hệ',
      url: 'contact',
      active: false,
    },
    {
      content: 'Thông tin',
      url: 'news',
      active: false,
    },
  ],
  colors: [
    { name: 'black', value: '#000' },
    { name: 'white', value: '#FFF' },
    { name: 'blue darken-4', value: '#0D47A1' },
    { name: 'yellow accent-2', value: '#FFFF00' },
    { name: 'deep-orange accent-3', value: '#FF3D00' },
    { name: 'deep-purple lighten-1', value: '#7E57C2' },
    { name: 'grey lighten-1', value: '#BDBDBD' },
  ],

  // Account
  login_title: 'Đăng nhập',
  register_title: 'Đăng ký',
  logout_title: 'Đăng xuất',
  profile_tille: 'Tài khoản',
  user_profile: 'Thông tin người dùng',
  close: 'Đóng',
  save: 'Lưa',
  phone: 'Số điện thoại',
  user_name: 'Tên người dùng',
  account_name: 'Tên tài khoản',
  repeatPassword: 'Nhập lại mật khẩu',
  password: 'Mật khẩu',
  forget_password: 'Quên mật khẩu',
  err_password: ['Mật khẩu có ít nhất', 'kí tự', 'Mật khẩu phải trùng khớp'],
  memu_account: [
    { title: 'Đăng ký', url: 'register' },
    { title: 'Đăng nhập', url: 'login' },
  ],

  // Filter
  selects: [
    'Giá tăng',
    'Giá giảm',
    'Tên: A - Z',
    'Tên: Z - A',
    'Mới nhất',
    'Bán chạy nhất',
    'Cũ nhất',
  ],

  // News
  trends: [
    {
      name: 'ÁO THUN',
      value: 100,
    },
    {
      name: 'ÁO SƠ MI',
      value: 75,
    },
    {
      name: 'VÁY',
      value: 90,
    },
  ],

  // Support_
  support_title: 'Hỗ trợ khách hàng',
  support: [
    'Phí giao hàng',
    'Hướng dẫn mua hàng',
    'Trả hàng',
    'Hướng dẫn kích thước',
  ],
  service_tille: 'Dịch vụ khách hàng',

  // 404
  service: ['Liên hệ chúng tôi', 'Phương thức thanh toán', 'Điểm thưởng'],
  notfound: ['Xin lỗi! Chùng tôi không tìm thấy thông tin', 'Trở về'],

  // Cart
  cart_tille: [
    'Hình ảnh',
    'Tên sản phẩm',
    'Giá',
    'Số lượng',
    'Tổng tiền',
    'Xóa',
  ],
  total: 'Tổng tiền',
  checkout: 'Thanh toán',
  currency: 'đ',
})
