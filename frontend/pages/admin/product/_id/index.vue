<template>
  <v-container>
    <v-row>
      <v-col cols="12" sm="6">
        <v-card>
          <v-card-text>
            <v-row
              ><v-col><h5>Thông tin chi tiết sản phẩm</h5></v-col
              ><v-spacer></v-spacer>
              <v-col class="d-flex justify-content-end"
                ><v-btn
                  v-show="editProduct"
                  color="primary"
                  elevation="2"
                  plain
                  icon
                  @click="editProduct = !editProduct"
                  ><v-icon>mdi-pencil</v-icon></v-btn
                >
                <v-btn
                  v-show="!editProduct"
                  class="mr-1"
                  color="primary"
                  small
                  fab
                  @click="submit"
                  ><v-icon>mdi-check</v-icon></v-btn
                >
                <v-btn
                  v-show="!editProduct"
                  color="error"
                  fab
                  small
                  @click="resert"
                  ><v-icon>mdi-cancel</v-icon></v-btn
                >
              </v-col> </v-row
            ><v-divider></v-divider>
            <v-container>
              <v-row>
                <v-col cols="12" sm="6">
                  <v-text-field
                    v-model.trim="products.name"
                    label="Tên sản phẩm"
                    outlined
                    :readonly="editProduct"
                  ></v-text-field>
                </v-col>
                <v-col cols="12" sm="6">
                  <v-text-field
                    v-model.number="products.price"
                    label="Giá tiền"
                    outlined
                    :readonly="editProduct"
                  ></v-text-field>
                </v-col>
              </v-row>
              <v-row>
                <v-col>
                  <v-card outlined>
                    <v-row> <v-col> Hình ảnh</v-col></v-row>
                    <v-row>
                      <v-col>
                        <v-img
                          :src="products.image"
                          max-height="200"
                          max-width="200"
                          contain
                        ></v-img>
                      </v-col>
                    </v-row>
                  </v-card>
                </v-col>
                <v-col cols="12" sm="6">
                  <v-list-item three-line>
                    <v-list-item-content>
                      <v-list-item-title>Danh mục</v-list-item-title>
                      <v-list-item-subtitle
                        v-for="category in products.category"
                        :key="category.id"
                      >
                        {{ category }}
                      </v-list-item-subtitle>
                    </v-list-item-content>
                  </v-list-item>
                </v-col>
              </v-row>
              <v-row>
                <v-col cols="12" sm="12">
                  <v-textarea
                    v-model="products.info_small"
                    label="Mô tả ngắn"
                    outlined
                    :readonly="editProduct"
                  >
                  </v-textarea>
                </v-col>
              </v-row>
              <v-row>
                <v-col cols="12" sm="12">
                  Mô tả chi tiết
                  <vue-editor
                    id="editor"
                    v-model="products.info"
                    use-custom-image-handler
                    :readonly="editProduct"
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
                ><h5>Thông tin chi tiết sản phẩm</h5>
                <v-divider></v-divider>
                <v-card
                  v-for="(
                    itemDetailsProduct, indexDetailsproduct
                  ) in products.detailsProduct"
                  :key="indexDetailsproduct"
                  elevation="2"
                  class="mt-2"
                >
                  <v-container>
                    <v-row>
                      <v-col>
                        <v-card-text><p>Màu sắc</p></v-card-text></v-col
                      >

                      <v-col class="d-flex justify-content-end"
                        ><v-btn
                          v-show="editProduct"
                          color="primary"
                          elevation="2"
                          plain
                          icon
                          @click="editProduct = !editProduct"
                          ><v-icon>mdi-pencil</v-icon></v-btn
                        >
                        <v-btn
                          v-show="!editProduct"
                          class="mr-1"
                          color="primary"
                          small
                          fab
                          @click="submit"
                          ><v-icon>mdi-check</v-icon></v-btn
                        >
                        <v-btn
                          v-show="!editProduct"
                          color="error"
                          fab
                          small
                          @click="resert"
                          ><v-icon>mdi-cancel</v-icon></v-btn
                        >
                      </v-col>
                    </v-row>

                    <v-divider></v-divider>
                    <v-row>
                      <v-col sm="6" cols="12">
                        <v-select
                          v-model="itemDetailsProduct.color"
                          :items="colors"
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
                          <v-row> <v-col> Hình ảnh</v-col></v-row>
                          <v-row>
                            <v-col cols="2" sm="2">
                              <v-file-input
                                hide-input
                                accept="image/png, image/jpeg, image/bmp"
                              ></v-file-input>
                              <v-btn text icon
                                ><v-icon>mdi-close</v-icon></v-btn
                              >
                            </v-col>
                            <v-col cols="10" sm="10">
                              <v-img
                                v-model="itemDetailsProduct.image"
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
                        <v-btn class="mr-1" color="primary" small fab
                          ><v-icon>mdi-plus</v-icon></v-btn
                        >
                        <v-btn color="error" fab small
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
                          v-model="itemSize.name"
                          label="Tên kích thước"
                          outlined
                          clearable
                          required
                        ></v-text-field>
                      </v-col>
                      <v-col sm="6" cols="12">
                        <v-text-field
                          v-model="itemSize.amount"
                          label="Số lượng"
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
</template>

<script>
import { mapGetters } from 'vuex'
export default {
  layout: 'admin',
  data: () => ({
    editProduct: true,
  }),
  computed: {
    ...mapGetters({
      // map `this.doneCount` to `this.$store.getters.doneTodosCount`
      product: 'admin/product/getFindProduct',
      color: 'admin/color/getColor',
    }),
    products: {
      get() {
        const item = this.product({ id: this.$route.params.id })
        if (item) {
          return this.$_.cloneDeep(item)
        }
        return {}
      },
      set(value) {
        this.products = value
      },
    },
    colors() {
      const item = this.color
      if (item) {
        return this.$_.cloneDeep(item)
      }
      return {}
    },
  },
  methods: {
    resert() {
      this.editProduct = !this.editProduct
    },
    submit() {
      this.editProduct = !this.editProduct
    },
  },
}
</script>

<style></style>
