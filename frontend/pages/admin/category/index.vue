<template>
  <v-data-table
    :headers="headers"
    :items="category"
    :search="search"
    sort-by="calories"
    class="elevation-1"
  >
    <template #[`top`]>
      <v-toolbar flat>
        <v-toolbar-title>{{ title }}</v-toolbar-title>
        <v-divider class="mx-4" inset vertical></v-divider>
        <v-text-field
          v-model="search"
          append-icon="mdi-magnify"
          label="Search"
          single-line
          hide-details
        ></v-text-field>
        <v-spacer></v-spacer>
        <v-dialog v-model="dialog" max-width="500px">
          <template #[`activator`]="{ on, attrs }">
            <v-btn color="primary" dark class="mb-2" v-bind="attrs" v-on="on">
              {{ btnNew }}
            </v-btn>
          </template>
          <v-card>
            <v-card-title>
              <span class="headline">{{ formTitle }}</span>
            </v-card-title>

            <v-card-text>
              <v-container>
                <v-row>
                  <v-col cols="12" sm="6" md="4">
                    <v-text-field
                      v-model="editedItem.name"
                      label="Tên"
                      required
                    ></v-text-field>
                  </v-col>
                  <v-col cols="12" sm="6" md="4">
                    <v-text-field
                      v-model="editedItem.sort"
                      min="1"
                      type="number"
                      label="Độ ưu tiên"
                    ></v-text-field>
                  </v-col>
                  <v-col cols="12" sm="6" md="4">
                    <v-select
                      v-model="editedItem.category"
                      :items="select"
                      item-value="name"
                      item-text="name"
                      label="Cha"
                      required
                    ></v-select
                  ></v-col>
                </v-row>
              </v-container>
            </v-card-text>

            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn color="blue darken-1" text @click="close"> Cancel </v-btn>
              <v-btn color="blue darken-1" text @click="save"> Save </v-btn>
            </v-card-actions>
          </v-card>
        </v-dialog>
        <v-dialog v-model="dialogDelete" max-width="500px">
          <v-card>
            <v-card-title class="headline"
              >Bạn thật sự muốn xoá không?</v-card-title
            >
            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn color="blue darken-1" text @click="closeDelete"
                >Cancel</v-btn
              >
              <v-btn color="blue darken-1" text @click="deleteItemConfirm"
                >OK</v-btn
              >
              <v-spacer></v-spacer>
            </v-card-actions>
          </v-card>
        </v-dialog>
      </v-toolbar>
    </template>
    <template #[`item.actions`]="{ item }">
      <v-icon small class="mr-2" @click="editItem(item)"> mdi-pencil </v-icon>
      <v-icon small @click="deleteItem(item)"> mdi-delete </v-icon>
    </template>
    <!-- <template #[no-data]>
      <v-btn color="primary" @click="initialize"> Reset </v-btn>
    </template> -->
  </v-data-table>
</template>

<script>
export default {
  layout: 'admin',
  data: () => ({
    dialog: false,
    dialogDelete: false,
    search: '',
    editedIndex: -1,
    btnNew: 'Thêm',
    editedItem: {
      name: '',
      sort: 1,
      category: '',
    },
    title: 'Danh sách danh mục',
    headers: [
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
    data: [],
  }),
  head() {
    return {
      title: this.title,
      meta: [
        {
          hid: 'Danh sách danh mục',
          name: 'Danh sách danh mục',
          content: 'Danh sách danh mục vào cửa hàng 7755',
        },
      ],
    }
  },
  computed: {
    formTitle() {
      return this.editedIndex === -1 ? 'Thêm dữ liệu' : 'Sửa dữ liệu'
    },
    category() {
      return this.$store.state.admin.category.contents
    },
    select() {
      return this.$store.state.admin.category.select
    },
  },

  watch: {
    dialog(val) {
      val || this.close()
    },
    dialogDelete(val) {
      val || this.closeDelete()
    },
  },

  methods: {
    editItem(item) {
      this.editedIndex = this.category.indexOf(item)
      this.editedItem = Object.assign({}, item)
      this.dialog = true
    },

    deleteItem(item) {
      this.editedIndex = this.category.indexOf(item)
      this.editedItem = Object.assign({}, item)
      this.dialogDelete = true
    },

    deleteItemConfirm() {
      if (this.editedIndex > -1) {
        const item = Object.assign(
          this.category[this.editedIndex],
          this.editedItem
        )
        this.$store.dispatch('admin/category/deleteContent', item)
      } else {
        // this.desserts.push(this.editedItem)
      }
      this.closeDelete()
    },

    close() {
      this.dialog = false
      this.$nextTick(() => {
        this.editedItem = Object.assign({}, this.defaultItem)
        this.editedIndex = -1
      })
    },

    closeDelete() {
      this.dialogDelete = false
      this.$nextTick(() => {
        this.editedItem = Object.assign({}, this.defaultItem)
        this.editedIndex = -1
      })
    },

    save() {
      if (this.editedIndex > -1) {
        const item = Object.assign(
          this.category[this.editedIndex],
          this.editedItem
        )
        this.$store.dispatch('admin/category/updateContent', item)
      } else {
        this.$store.dispatch('admin/category/addContent', this.editedItem)
      }
      this.close()
    },
  },
}
</script>
