<template>
  <v-tabs centered icons-and-text>
    <v-tab>
      {{ $local.vn_admin_product.INFORMATION }}
      <v-icon> {{ $local.vn_admin_product.ICON_INFORMATION }}</v-icon>
    </v-tab>

    <v-tab>
      {{ $local.vn_admin_product.INFORMATION_DETAIL }}
      <v-icon>
        {{ $local.vn_admin_product.ICON_INFORMATION_DETAIL }}
      </v-icon>
    </v-tab>
    <v-tab>
      {{ $local.vn_admin_product.IMAGE }}
      <v-icon>{{ $local.vn_admin_product.ICON_IMAGE }}</v-icon>
    </v-tab>
    <v-tab>
      {{ $local.vn_admin_product.IMPORT }}
      <v-icon> {{ $local.vn_admin_product.ICON_IMPORT }}</v-icon>
    </v-tab>
    <v-tab-item>
      <v-form @submit.prevent="onSubmitInformation">
        <v-card>
          <v-card-text>
            <v-row
              ><v-col
                ><h5>{{ $local.vn_admin_product.INFORMATION }}</h5></v-col
              ><v-spacer></v-spacer>
              <v-col class="d-flex justify-content-end"
                ><v-btn
                  type="submit"
                  color="orange"
                  elevation="2"
                  outlined
                  plain
                  >{{ $local.vn_admin_product.BTN_EDIT }}</v-btn
                ></v-col
              > </v-row
            ><v-divider></v-divider>
            <v-container>
              <v-row>
                <v-col cols="12" sm="6">
                  <v-text-field
                    v-model="products.name"
                    :label="$local.vn_admin_product.NAME"
                    outlined
                    clearable
                    required
                  ></v-text-field>
                </v-col>
                <v-col cols="12" sm="6">
                  <v-text-field
                    v-model="products.price"
                    type="number"
                    :label="$local.vn_admin_product.PRICE"
                    outlined
                    clearable
                  ></v-text-field>
                </v-col>
              </v-row>
              <v-row>
                <v-col cols="12" sm="12">
                  <v-textarea
                    v-model="products.infoSmall"
                    :label="$local.vn_admin_product.SHORT_DESCRIPTION"
                    outlined
                    clearable
                  >
                  </v-textarea>
                </v-col>
              </v-row>
              <v-row>
                <v-col cols="12" sm="12">
                  <v-toolbar-bar>{{
                    $local.vn_admin_product.DETAILS_DESCRIPTION
                  }}</v-toolbar-bar>
                  <vue-editor
                    id="editor"
                    v-model="products.info"
                    use-custom-image-handler
                    @image-added="handleImageAdded"
                    @image-removed="handleImagDelete"
                  ></vue-editor>
                </v-col>
              </v-row>
            </v-container>
          </v-card-text>
        </v-card>
      </v-form>
    </v-tab-item>
    <v-tab-item>
      <v-card>
        <v-container>
          <v-row>
            <v-card-text>
              <h5>{{ $local.vn_admin_product.INFORMATION_DETAIL }}</h5>
              <v-divider></v-divider>
              <v-row>
                <v-col>
                  <v-card>
                    <v-treeview :items="colorItem" open-all> </v-treeview>
                  </v-card>
                </v-col>
                <v-col>
                  <v-card>
                    <v-container>
                      <v-row>
                        <v-col>
                          {{ $local.vn_admin_product.ADD_SIZE_COLOR }}
                        </v-col></v-row
                      >
                      <v-row>
                        <v-col
                          ><v-select
                            v-model="editSize.detailsProduct"
                            :items="colorItem"
                            item-value="id"
                            item-text="name"
                            :label="$local.vn_admin_product.COLOR"
                          ></v-select>
                        </v-col>
                        <v-col>
                          <v-text-field
                            v-model="editSize.name"
                            :label="$local.vn_admin_product.SIZE"
                            outlined
                          ></v-text-field></v-col
                        ><v-col>
                          <v-btn @click="addSize">{{
                            $local.vn_admin_product.BTN_ADD_SIZE
                          }}</v-btn>
                        </v-col>
                      </v-row>
                      <v-row>
                        <v-container>
                          <v-row>
                            <v-col>
                              <v-card-text
                                ><p>
                                  {{ $local.vn_admin_product.ADD_COLOR }}
                                </p></v-card-text
                              ></v-col
                            >
                            <v-col
                              ><v-btn @click="addColors">
                                {{ $local.vn_admin_product.ADD_COLOR }}</v-btn
                              ></v-col
                            >
                          </v-row>

                          <v-divider></v-divider>
                          <v-row>
                            <v-col sm="6" cols="12">
                              <v-select
                                v-model="addColor.color"
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
                                    <v-toolbar-bar
                                      >Hình ảnh</v-toolbar-bar
                                    ></v-col
                                  ></v-row
                                >
                                <v-row>
                                  <v-col cols="2" sm="2">
                                    <v-file-input
                                      hide-input
                                      accept="image/png, image/jpeg, image/bmp"
                                      @change="inputFile($event, addColor)"
                                    ></v-file-input>
                                    <v-btn
                                      text
                                      icon
                                      @click="addColor.image = ''"
                                      ><v-icon>mdi-close</v-icon></v-btn
                                    >
                                  </v-col>
                                  <v-col cols="10" sm="10">
                                    <v-img
                                      :src="addColor.image"
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
                              <v-card-text
                                ><p>Kích thước</p>
                              </v-card-text></v-col
                            >
                            <v-col class="d-flex justify-content-end">
                              <v-btn
                                class="mr-1"
                                color="primary"
                                small
                                fab
                                @click="addSizeArray(addColor)"
                                ><v-icon>mdi-plus</v-icon></v-btn
                              >
                            </v-col>
                          </v-row>
                          <v-row
                            v-for="(itemSize, indexSize) in addColor.size"
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
                            <v-col>
                              <v-btn
                                color="error"
                                fab
                                small
                                @click="
                                  deleteSizeArray(
                                    indexDetailsProduct,
                                    indexSize
                                  )
                                "
                                ><v-icon>mdi-minus</v-icon></v-btn
                              ></v-col
                            >
                          </v-row>
                        </v-container>
                      </v-row>
                      <v-row><v-col> </v-col></v-row>
                    </v-container> </v-card
                ></v-col>
              </v-row>
            </v-card-text>
          </v-row>
        </v-container>
      </v-card>
    </v-tab-item>
    <v-tab-item>
      <v-card flat> </v-card>
    </v-tab-item>
    <v-tab-item>
      <v-card flat>
        <v-card-text>
          <v-row
            ><v-col
              ><h5>{{ $local.vn_admin_product.ICON_IMPORT }}</h5></v-col
            ><v-spacer></v-spacer> </v-row
          ><v-divider></v-divider>
          <v-container>
            <v-row>
              <v-col>
                <v-select
                  v-model="activeColor"
                  :items="colorItem"
                  item-text="name"
                  item-value="children"
                  :label="$local.vn_admin_product.COLOR"
                  outlined
                />
              </v-col>
              <v-col
                ><v-select
                  v-model="addCoupon.id"
                  :items="activeColor"
                  item-text="name"
                  item-value="id"
                  :label="$local.vn_admin_product.SIZE"
                  outlined
              /></v-col>
              <v-col>
                <v-text-field
                  v-model="addCoupon.amount"
                  type="number"
                  :label="$local.vn_admin_product.AMOUNT"
                  outlined
                  clearable
                ></v-text-field>
              </v-col>
              <v-col class="d-flex justify-content-end"
                ><v-btn
                  color="orange"
                  elevation="2"
                  outlined
                  plain
                  @click="addCoupons"
                  >{{ $local.vn_admin_product.BTN_ADD_AMOUNT }}</v-btn
                ></v-col
              >
            </v-row>
          </v-container>
        </v-card-text>
      </v-card>
    </v-tab-item>
  </v-tabs>
</template>

<script>
import { mapGetters } from 'vuex'
export default {
  layout: 'admin',
  data: () => ({
    editProduct: true,
    editProductImage: true,
    defaultItem: {},
    colorItem: [],
    editColor: {},
    editSize: {},
    addColor: { size: [{}] },
    addCoupon: {},
    activeColor: {},
  }),
  computed: {
    ...mapGetters({
      // map `this.doneCount` to `this.$store.getters.doneTodosCount`
      product: 'admin/product/getFindProduct',
      color: 'admin/color/getAll',
    }),
    products() {
      const item = this.product({ id: this.$route.params.id })
      if (item) {
        this.cloneColor(item)
        return this.clone(item)
      }
      return {}
    },
    colors() {
      const item = this.products
      if (item) {
        return this.$_.cloneDeep(item)
      }
      return {}
    },
  },
  methods: {
    cloneColor(item) {
      item.detailsProduct.forEach((e) => {
        const sizes = []
        e.size.forEach((sizeItem) => {
          const size = {
            id: sizeItem.id,
            name:
              'Tên Size: ' + sizeItem.name + ' / Số lượng: ' + sizeItem.amount,
          }
          sizes.push(size)
        })
        const childers = {
          id: e.id,
          name: 'Màu ' + e.color.name,
          children: sizes,
        }

        this.colorItem.push(childers)
      })
    },
    clone(item) {
      this.defaultItem = this.$_.cloneDeep(item)
      return this.defaultItem
    },
    resert() {
      this.editProduct = !this.editProduct
    },
    submit() {
      this.editProduct = !this.editProduct
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
    async handleImageAdded(file, Editor, cursorLocation, resetUploader) {
      if (!file) return
      try {
        this.$toast.global.loading()
        const formData = new FormData()
        formData.append('file', file)
        await this.$axios
          .$post('http://localhost:8080/api/admin/file', formData)
          .then((response) => {
            Editor.insertEmbed(cursorLocation, 'image', response.url)
            resetUploader()
            this.$toast.global.success()
          })
      } catch (e) {
        this.$toast.global.error()
      }
    },
    handleImagDelete(file) {},
    onSubmitInformation(event) {
      event.preventDefault()
      this.$store.dispatch(
        this.$constant.admin.ACTION_ADMIN_PRODUCT_UPDATE,
        this.products
      )
    },
    addSize() {
      this.$store.dispatch(
        this.$constant.admin.ACTION_ADMIN_SIZE_ADD,
        this.editSize
      )
    },
    addSizeArray() {
      this.addColor.size.push({})
    },
    deleteSizeArray(indexSize) {
      this.addColor.size.splice(indexSize, 1)
    },
    addColors() {
      this.addColor.product = this.products.id
      this.$store.dispatch(
        this.$constant.admin.ACTION_ADMIN_DETAILS_PRODUCT_ADD,
        this.addColor
      )
    },
    addCoupons() {
      this.$store.dispatch(
        this.$constant.admin.ACTION_ADMIN_SIZE_UPDATE,
        this.addCoupon
      )
    },
  },
}
</script>

<style></style>
