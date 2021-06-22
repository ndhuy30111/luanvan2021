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
      <v-form
        ref="form"
        v-model="validInformation"
        lazy-validation
        @submit.prevent="onSubmitInformation"
      >
        <v-card>
          <v-card-text>
            <v-row
              ><v-col
                ><h5>{{ $local.vn_admin_product.INFORMATION }}</h5></v-col
              ><v-spacer></v-spacer>
              <v-col class="d-flex justify-content-end"
                ><v-btn
                  :disabled="!validInformation"
                  type="submit"
                  color="orange"
                  elevation="2"
                  outlined
                  plain
                  @click="validateInformation"
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
                    :rules="$rule.ADMIN_PRODUCT_NAME"
                    outlined
                    required
                  ></v-text-field>
                </v-col>
                <v-col cols="12" sm="6">
                  <v-text-field
                    v-model="products.price"
                    v-mask="'#########'"
                    :rules="$rule.ADMIN_PRODUCT_PRICE"
                    :label="$local.vn_admin_product.PRICE"
                    outlined
                    suffix="₫"
                  ></v-text-field>
                </v-col>
              </v-row>
              <v-row>
                <v-col cols="12" sm="12">
                  <v-textarea
                    v-model="products.infoSmall"
                    :label="$local.vn_admin_product.SHORT_DESCRIPTION"
                    :rules="$rule.ADMIN_PRODUCT_SHORT_DESCRIPTION"
                    outlined
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
                      <v-form
                        ref="formColorSize"
                        v-model="validColorSize"
                        lazy-validation
                        @submit.prevent="SubmitaddSize"
                      >
                        <v-row>
                          <v-col
                            ><v-select
                              v-model="editSize.detailsProduct"
                              :items="colorItem"
                              item-value="id"
                              item-text="name"
                              :label="$local.vn_admin_product.COLOR"
                              :rules="$rule.ADMIN_PRODUCT_COLOR_NAME"
                            ></v-select>
                          </v-col>
                          <v-col>
                            <v-text-field
                              v-model="editSize.name"
                              :label="$local.vn_admin_product.SIZE"
                              :rules="$rule.ADMIN_PRODUCT_NAME_SIZE"
                              outlined
                            ></v-text-field></v-col
                          ><v-col>
                            <v-btn
                              :disabled="!validColorSize"
                              type="submit"
                              color="orange"
                              elevation="2"
                              outlined
                              plain
                              @click="validateColorSize"
                              >{{ $local.vn_admin_product.BTN_ADD_SIZE }}</v-btn
                            >
                          </v-col>
                        </v-row>
                      </v-form>
                      <v-row>
                        <v-container>
                          <v-form
                            ref="formColor"
                            v-model="validColor"
                            lazy-validation
                            @submit.prevent="SubmitaddColor"
                          >
                            <v-row>
                              <v-col>
                                <v-card-text
                                  ><p>
                                    {{ $local.vn_admin_product.ADD_COLOR }}
                                  </p></v-card-text
                                ></v-col
                              >
                              <v-col
                                ><v-btn
                                  :disabled="!validColor"
                                  type="submit"
                                  color="orange"
                                  elevation="2"
                                  outlined
                                  plain
                                  @click="validateColor"
                                >
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
                                  :rules="$rule.ADMIN_PRODUCT_COLOR_NAME"
                                  item-text="name"
                                  item-value="id"
                                  :label="$local.vn_admin_product.COLOR"
                                  outlined
                                >
                                  <template #selection="{ item }">
                                    <v-chip
                                      :text-color="
                                        item.code == '#FFFFFF'
                                          ? 'black'
                                          : 'white'
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
                                      <v-toolbar-bar>{{
                                        $local.vn_admin_product.IMAGE
                                      }}</v-toolbar-bar></v-col
                                    ></v-row
                                  >
                                  <v-row>
                                    <v-col cols="2" sm="2">
                                      <v-file-input
                                        :rules="$rule.ADMIN_PRODUCT_COLOR_IMAGE"
                                        hide-input
                                        accept="image/png, image/jpeg, image/bmp"
                                        @change="inputFile($event, addColor)"
                                      ></v-file-input>
                                      <v-btn
                                        text
                                        icon
                                        @click="addColor.image = ''"
                                        ><v-icon>{{
                                          $local.vn_admin_product.ICON_BTN_CLOSE
                                        }}</v-icon></v-btn
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
                                  ><p>{{ $local.vn_admin_product.SIZE }}</p>
                                </v-card-text></v-col
                              >
                              <v-col class="d-flex justify-content-end">
                                <v-btn
                                  class="mr-1"
                                  color="primary"
                                  small
                                  fab
                                  @click="addSizeArray(addColor)"
                                  ><v-icon>{{
                                    $local.vn_admin_product.ICON_ADD_PLUS
                                  }}</v-icon></v-btn
                                >
                              </v-col>
                            </v-row>
                            <v-row
                              v-for="(itemSize, indexSize) in addColor.size"
                              :key="indexSize"
                            >
                              <v-col sm="6" cols="12">
                                <v-text-field
                                  v-model="itemSize.name"
                                  :rules="$rule.ADMIN_PRODUCT_NAME_SIZE"
                                  :label="$local.vn_admin_product.NAME_SIZE"
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
                                  ><v-icon
                                    >$local.vn_admin_product.ICON_DEL_MINUS</v-icon
                                  ></v-btn
                                ></v-col
                              >
                            </v-row>
                          </v-form>
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
              ><h5>{{ $local.vn_admin_product.IMPORT }}</h5></v-col
            ><v-spacer></v-spacer> </v-row
          ><v-divider></v-divider>
          <v-container>
            <v-form
              ref="formCoupon"
              v-model="validCoupn"
              lazy-validation
              @submit.prevent="SubmitaddCoupons"
            >
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
                    type="submit"
                    color="orange"
                    elevation="2"
                    outlined
                    plain
                    @click="validateCoupon"
                    >{{ $local.vn_admin_product.BTN_ADD_AMOUNT }}</v-btn
                  ></v-col
                >
              </v-row>
            </v-form>
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
    validInformation: false,
    validColorSize: false,
    validColor: false,
    validCoupn: false,
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
      return { name: '' }
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
    SubmitaddSize() {
      this.$store.dispatch(
        this.$constant.admin.ACTION_ADMIN_SIZE_ADD,
        this.editSize
      )
      this.goBack()
    },
    SubmitaddColor() {
      this.addColor.product = this.products.id
      this.$store.dispatch(
        this.$constant.admin.ACTION_ADMIN_DETAILS_PRODUCT_ADD,
        this.addColor
      )
      this.goBack()
    },
    SubmitaddCoupons() {
      this.$store.dispatch(
        this.$constant.admin.ACTION_ADMIN_SIZE_UPDATE,
        this.addCoupon
      )
      this.goBack()
    },
    addSizeArray() {
      this.addColor.size.push({})
    },
    deleteSizeArray(indexSize) {
      this.addColor.size.splice(indexSize, 1)
    },

    validateInformation() {
      this.$refs.form.validate()
    },
    validateColorSize() {
      this.$refs.formColorSize.validate()
    },
    validateColor() {
      this.$refs.formColor.validate()
    },
    validateCoupon() {
      this.$refs.formCoupon.validate()
    },
    goBack() {
      window.history.length > 1 ? this.$router.go(0) : this.$router.push('/')
    },
  },
}
</script>

<style></style>
