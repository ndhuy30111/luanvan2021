<template>
  <form @submit.prevent="onSubmit">
    <v-container>
      <v-row>
        <v-col cols="12" sm="6">
          <v-card>
            <v-card-text>
              <v-row
                ><v-col><h5>Thêm thông tin sản phẩm</h5></v-col
                ><v-spacer></v-spacer>
                <v-col
                  ><v-btn
                    type="submit"
                    color="orange"
                    elevation="2"
                    outlined
                    plain
                    >Thêm sản sẩm</v-btn
                  ></v-col
                > </v-row
              ><v-divider></v-divider>
              <v-container>
                <v-row>
                  <v-col cols="12" sm="6">
                    <v-text-field
                      v-model.trim="form.name"
                      label="Tên sản phẩm"
                      outlined
                      clearable
                      required
                    ></v-text-field>
                  </v-col>
                  <v-col cols="12" sm="6">
                    <v-text-field
                      v-model.number="form.price"
                      label="Giá tiền"
                      outlined
                      clearable
                    ></v-text-field>
                  </v-col>
                </v-row>
                <v-row>
                  <v-col height="auto">
                    <v-card outlined>
                      <v-row>
                        <v-col>
                          <v-toolbar-bar>Hình ảnh</v-toolbar-bar></v-col
                        ></v-row
                      >
                      <v-row>
                        <v-col cols="2" sm="2">
                          <v-file-input
                            hide-input
                            accept="image/png, image/jpeg, image/bmp"
                            label="Avatar"
                            @change="inputFile($event, form)"
                          ></v-file-input>
                          <v-btn text icon @click="form.image = ''"
                            ><v-icon>mdi-close</v-icon></v-btn
                          >
                        </v-col>
                        <v-col cols="10" sm="10">
                          <v-img
                            :src="form.image"
                            max-height="200"
                            max-width="200"
                            contain
                          ></v-img>
                        </v-col>
                      </v-row>
                    </v-card>
                  </v-col>
                  <v-col cols="12" sm="6">
                    <v-toolbar-bar> Danh mục</v-toolbar-bar>
                    <Treeselect
                      v-model="form.category"
                      :options="category"
                      :normalizer="normalizer"
                      :disable-branch-nodes="false"
                    >
                    </Treeselect
                  ></v-col>
                </v-row>
                <v-row>
                  <v-col cols="12" sm="12">
                    <v-textarea
                      v-model="form.info_samll"
                      label="Mô tả ngắn"
                      outlined
                      clearable
                    >
                    </v-textarea>
                  </v-col>
                </v-row>
                <v-row>
                  <v-col cols="12" sm="12">
                    <v-toolbar-bar>Mô tả chi tiết</v-toolbar-bar>
                    <vue-editor
                      id="editor"
                      v-model="form.info"
                      use-custom-image-handler
                      @image-added="handleImageAdded"
                      @image-removed="handleImagDelete"
                    ></vue-editor>
                  </v-col>
                </v-row>
              </v-container>
            </v-card-text>
          </v-card>
        </v-col>
        <v-col cols="12" sm="6">
          <v-card>
            <v-container>
              <v-row>
                <v-card-text
                  ><p>Thêm thông tin chi tiết sản phẩm</p>
                  <v-divider></v-divider>

                  <v-card
                    v-for="(
                      itemDetailsProduct, indexColor
                    ) in form.detailsProduct"
                    :key="indexColor"
                    elevation="2"
                    class="mt-2"
                  >
                    <v-container>
                      <v-row>
                        <v-col>
                          <v-card-text><p>Màu sắc</p></v-card-text></v-col
                        >

                        <v-col class="d-flex justify-content-end">
                          <v-btn
                            class="mr-1"
                            color="primary"
                            small
                            fab
                            @click="addColor"
                            ><v-icon>mdi-plus</v-icon></v-btn
                          >
                          <v-btn
                            color="error"
                            fab
                            small
                            @click="deleteColor(indexColor)"
                            ><v-icon>mdi-minus</v-icon></v-btn
                          ></v-col
                        >
                      </v-row>

                      <v-divider></v-divider>
                      <v-row>
                        <v-col sm="6" cols="12">
                          <v-select
                            v-model="itemDetailsProduct.color"
                            :items="color"
                            item-text="name"
                            item-value="id"
                            label="Màu"
                            outlined
                          >
                            <template #selection="{ item }">
                              <v-chip
                                :text-color="
                                  item.code == '#FFFFFF' ? 'black' : 'white'
                                "
                                :color="item.code"
                              >
                                <span class="mr-2">{{ item.name }}</span>
                                {{ item.code }}</v-chip
                              >
                            </template></v-select
                          ></v-col
                        >
                        <v-col height="auto">
                          <v-card outlined>
                            <v-row>
                              <v-col>
                                <v-toolbar-bar>Hình ảnh</v-toolbar-bar></v-col
                              ></v-row
                            >
                            <v-row>
                              <v-col cols="2" sm="2">
                                <v-file-input
                                  hide-input
                                  accept="image/png, image/jpeg, image/bmp"
                                  @change="
                                    inputFile($event, itemDetailsProduct)
                                  "
                                ></v-file-input>
                                <v-btn
                                  text
                                  icon
                                  @click="itemDetailsProduct.image = ''"
                                  ><v-icon>mdi-close</v-icon></v-btn
                                >
                              </v-col>
                              <v-col cols="10" sm="10">
                                <v-img
                                  :src="itemDetailsProduct.image"
                                  max-height="200"
                                  max-width="200"
                                  contain
                                ></v-img>
                              </v-col>
                            </v-row>
                          </v-card>
                        </v-col>
                      </v-row>
                      <v-row>
                        <v-col>
                          <v-card-text><p>Kích thước</p> </v-card-text></v-col
                        >
                        <v-col class="d-flex justify-content-end">
                          <v-btn
                            class="mr-1"
                            color="primary"
                            small
                            fab
                            @click="addSize(indexColor)"
                            ><v-icon>mdi-plus</v-icon></v-btn
                          >
                          <v-btn
                            color="error"
                            fab
                            small
                            @click="deleteSize(indexColor, indexSize)"
                            ><v-icon>mdi-minus</v-icon></v-btn
                          ></v-col
                        >
                      </v-row>
                      <v-row
                        v-for="(itemSize, indexSize) in itemDetailsProduct.size"
                        :key="indexSize"
                      >
                        <v-col sm="6" cols="12">
                          <v-text-field
                            v-model.trim="itemSize.name"
                            label="Tên kích thước"
                            outlined
                            clearable
                            required
                          ></v-text-field>
                        </v-col>
                      </v-row>
                    </v-container>
                  </v-card>
                </v-card-text>
              </v-row>
            </v-container>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
  </form>
</template>

<script>
import Treeselect from '@riophae/vue-treeselect'
import '@riophae/vue-treeselect/dist/vue-treeselect.css'
export default {
  components: { Treeselect },
  layout: 'admin',
  data: () => ({
    form: {
      name: '',
      price: 0,
      image: '',
      info: '',
      info_samll: '',
      category: null,
      detailsProduct: [
        {
          image: '',
          color: null,
          size: [
            {
              name: '',
              amount: 0,
            },
          ],
        },
      ],
    },
    normalizer(node) {
      return {
        id: node.id,
        label: node.name,
        children: node.children,
      }
    },
    imageproduct: undefined,
    image: '',
    menu: false,
  }),
  computed: {
    category() {
      return this.$store.state.admin.category.select
    },
    color() {
      return this.$store.state.admin.color.color
    },
  },

  methods: {
    async handleImageAdded(file, Editor, cursorLocation, resetUploader) {
      if (!file) return
      try {
        const formData = new FormData()
        formData.append('file', file)
        await this.$axios
          .$post('http://localhost:8080/api/admin/file', formData)
          .then((response) => {
            Editor.insertEmbed(cursorLocation, 'image', response.url)
            resetUploader()
          })
      } catch (e) {
        console.log(e)
      }
    },
    async handleImagDelete(file, Editor, cursorLocation, resetUploader) {
      if (!file) return
      try {
        const formData = new FormData()
        formData.append('file', file)
        await this.$axios
          .$post('http://localhost:8080/api/admin/file', formData)
          .then((response) => {
            Editor.insertEmbed(cursorLocation, 'image', response.url)
            resetUploader()
          })
      } catch (event) {
        alert('Lỗi')
      }
    },
    async inputFile(event, item) {
      item.image = await this.createBase64Image(event)
    },
    async createBase64Image(file) {
      const readData = (f) =>
        new Promise((resolve) => {
          const reader = new FileReader()
          reader.onloadend = () => resolve(reader.result)
          reader.readAsDataURL(f)
        })
      /* Read data */
      return await readData(file)
    },
    addColor() {
      const itemDetailsProduct = {
        name: '',
        image: '',
        code: '#1976D2FF',
        size: [
          {
            name: '',
            amount: 0,
          },
        ],
      }
      this.form.detailsProduct.push(itemDetailsProduct)
    },
    addSize(indexColor) {
      const itemSize = {
        name: '',
        amount: 0,
      }
      this.form.detailsProduct[indexColor].size.push(itemSize)
    },
    deleteColor(indexColor) {
      if (indexColor === 0) return
      this.form.detailsProduct.splice(indexColor, 1)
    },
    deleteSize(indexColor, indexSize) {
      if (indexColor === 0) return
      this.form.detailsProduct[indexColor].size.splice(indexSize, 1)
    },
    onSubmit(event) {
      event.preventDefault()
      this.$store.dispatch('admin/product/addProduct', this.form)
    },
  },
}
</script>

<style></style>
