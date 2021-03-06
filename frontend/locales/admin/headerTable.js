export default () => ({
  CATEGORY_HEADER: [
    {
      text: 'Tên loại sản phẩm',
      align: 'start',
      value: 'name',
    },
    { text: 'Đường dẫn', value: 'url' },
    { text: 'Độ ưu tiên', value: 'sort' },
    { text: 'Loại sản phẩm Cha', value: 'category' },
    { text: 'Ngày tạo', value: 'createDate' },
    { text: 'Người tạo', value: 'createBy' },
    { text: 'Người cập nhập', value: 'lastModifiedBy' },
    { text: 'Ngày cập nhập', value: 'lastModifiedDate' },

    { text: '', value: 'actions', sortable: false },
  ],
  SUPPLIER_HEADER: [
    {
      text: 'Tên nhà cung cấp',
      align: 'start',
      value: 'name',
    },
    { text: 'Số điện thoại', value: 'number' },
    { text: 'Địa chỉ', value: 'address' },
    { text: 'Website', value: 'website' },
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
      text: 'Tên sản phẩm',
      align: 'start',
      value: 'name',
    },
    { text: 'Nhà cung cấp', value: 'supplier' },
    { text: 'Đường dẫn', value: 'url' },
    { text: 'Loại sản phẩm', value: 'category' },
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
  REVIEW_HEADER: [
    {
      text: 'Tên sản phẩm',
      align: 'start',
      value: 'product',
    },
    { text: 'Tên người nhận xét', value: 'user' },
    { text: 'Đánh giá', value: 'rate' },
    { text: 'Lời bình luận', value: 'comment' },
    { text: 'Vào lúc mấy giờ', value: 'createDate' },
    { text: '', value: 'actions', sortable: false },
  ],
  INVOICE_HEADER: [
    {
      text: 'Mã đơn hàng',
      align: 'start',
      value: 'id',
    },
    { text: 'Số điện thoại', value: 'numberPhone' },
    { text: 'Tên người đặt', value: 'user' },
    { text: 'Địa chỉ', value: 'address' },
    { text: 'Ngày đăng hàng', value: 'createDate' },
    { text: 'Trạng thái đơn hàng', value: 'status' },
    { text: '', value: 'actions', sortable: false },
  ],
  BANNER_HEADER: [{ text: 'Độ ưu tiên' }, { text: 'Hình' }, { text: '' }],
})
