export default () => ({
  CATEGORY_HEADER: [
    {
      text: 'Tên danh mục',
      align: 'start',
      value: 'name',
    },
    { text: 'Đường dẫn', value: 'url' },
    { text: 'Độ ưu tiên', value: 'sort' },
    { text: 'Danh mục Cha', value: 'category' },
    { text: 'Ngày tạo', value: 'createDate' },
    { text: 'Người tạo', value: 'createBy' },
    { text: 'Người cập nhập', value: 'lastModifiedBy' },
    { text: 'Ngày cập nhập', value: 'lastModifiedDate' },

    { text: '', value: 'actions', sortable: false },
  ],
  COLOR_HEADER: [
    {
      text: 'Tên màu',
      align: 'start',
      value: 'name',
    },
    { text: 'Mã màu', value: 'code' },
    { text: '', value: 'actions', sortable: false },
  ],
  PRODUCT_HEADER: [
    {
      text: 'Tên danh mục',
      align: 'start',
      value: 'name',
    },
    { text: 'Đường dẫn', value: 'url' },
    { text: 'Danh mục', value: 'category' },
    { text: 'Ngày tạo', value: 'createDate' },
    { text: 'Người tạo', value: 'createBy' },
    { text: 'Người cập nhập', value: 'lastModifiedBy' },
    { text: 'Ngày cập nhập', value: 'lastModifiedDate' },

    { text: '', value: 'actions', sortable: false },
  ],
  IMAGE_HEADER: [
    { text: 'Loại hình ảnh' },
    { text: 'Tên' },
    { text: 'Hình' },
    { text: '' },
    { text: '' },
    { text: '' },
  ],
  COUPON_HEADER: [
    { text: 'Tên Sản phẩm', align: 'start', value: 'nameProduct' },
    { text: 'Tên màu', value: 'nameColor' },
    { text: 'Tên kích thước', value: 'nameSize' },
    { text: 'Số lượng', value: 'amount' },
    { text: 'Lý do', value: 'message' },
    { text: 'Trạng thái', value: 'status' },
    { text: 'Người tạo', value: 'createBy' },
    { text: 'Ngày tạo', value: 'createDate' },
    { text: 'Người cập nhập', value: 'lastModifiedBy' },
    { text: 'Ngày cập nhập', value: 'lastModifiedDate' },

    { text: '', value: 'actions', sortable: false },
  ],
})
