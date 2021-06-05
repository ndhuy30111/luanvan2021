export default () => ({
  admin: 'Quản trị viên',
  home: 'Trang chủ',
  delete_msg: 'Bạn thật sự muốn xoá không?',
  menu: [
    {
      name: 'Chủ cửa hàng',
      function: [
        {
          name: 'Quản lý khuyến mãi',
          function: [
            { name: 'Xem Khuyến mã', url: 'index' },
            { name: 'Thêm Khuyến mã', url: 'add' },
          ],
        },
      ],
    },
    {
      name: 'Quản lý nội dung',
      function: [
        {
          name: 'Quản lý Danh mục',
          function: [{ name: 'Xem Danh mục', url: 'admin-category' }],
        },
        {
          name: 'Quản lý sản phẩm',
          function: [
            { name: 'Xem danh sách', url: 'admin-product' },
            { name: 'Thêm sản phẩm', url: 'admin-product-add' },
          ],
        },
        {
          name: 'Quản lý màu sắc',
          function: [{ name: 'Xem danh sách màu sắc', url: 'admin-color' }],
        },
        {
          name: 'Quản lý Banner',
          function: [
            { name: 'Xem Banner', url: 'index' },
            { name: 'Thêm Banner', url: 'add' },
          ],
        },
      ],
    },
  ],

  // Category
  category_title: 'Danh sách danh mục',
  add_category: 'Thêm danh mục',
  category_headers: [
    {
      text: 'Tên danh mục',
      align: 'start',
      value: 'name',
    },
    { text: 'Đường dẫn', value: 'url' },
    { text: 'Độ ưu tiên', value: 'sort' },
    { text: 'Cha', value: 'category' },
    { text: 'Ngày tạo', value: 'createDate' },
    { text: 'Người tạo', value: 'createBy' },
    { text: 'Người cập nhập', value: 'lastModifiedBy' },
    { text: 'Ngày cập nhập', value: 'lastModifiedDate' },

    { text: '', value: 'actions', sortable: false },
  ],

  // Color
  color_title: 'Danh sách màu sắc',
  add_color: 'Thêm màu sắc',
  color_headers: [
    {
      text: 'Tên màu',
      align: 'start',
      value: 'name',
    },
    { text: 'mã màu', value: 'code' },
  ],

  // Login
  login: 'Đăng nhập',
  error_login: 'Bạn không thể truy cập',
})
