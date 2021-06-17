export default () => ({
  ADMIN_CATEGORY_NAME: [
    (v) => !!v || 'Bặt buộc nhập tên',
    (v) => v.length <= 15 || 'Bạn không được nhập quá 15 ký tự',
  ],
  ADMIN_CATEGORY_SORT: [
    (v) => !!v || 'Bặt buộc nhập độ ưu tiên',
    (v) => typeof v === 'string' || 'Bạn phải nhập số',
    (v) => v > 0 || 'Bạn phải nhập độ ưu tiên lớn hơn 0',
  ],
})
