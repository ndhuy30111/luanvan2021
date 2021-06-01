<template>
  <b-container class="shopping-cart">
    <b-row>
      <b-col cols="12" md="12">
        <div class="cart-table">
          <table>
            <thead>
              <tr>
                <th>Image</th>
                <th class="p-name">Product Name</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Total</th>
                <th>Delete</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td class="cart-pic" style="width: 21%">
                  <a href="productdetail">
                    <img
                      src="https://cdn.shopify.com/s/files/1/2598/7400/products/012_grande.jpg?v=1514365627"
                      alt=""
                      style="width: 50%"
                    />
                  </a>
                </td>
                <td class="cart-title">
                  <h5>product name / color / size</h5>
                </td>
                <td class="p-price">{{ price.toLocaleString() }} đ</td>
                <td class="qua-col">
                  <div class="quantity">
                    <div class="pro-qty">
                      {{ quantity }}
                    </div>
                  </div>
                </td>
                <td class="total-price">
                  {{ (price * quantity).toLocaleString() }} đ
                </td>
                <td class="close-td">
                  <b-icon icon="trash" style="cursor: pointer"></b-icon>
                </td>
              </tr>
            </tbody>
          </table>
        </div>
      </b-col>
    </b-row>
    <b-row>
      <b-col class="col-lg-4 offset-lg-8">
        <div class="proceed-checkout">
          <ul>
            <li class="cart-total">
              Total <span>{{ total.toLocaleString() }}</span>
            </li>
          </ul>
          <a href="#" class="proceed-btn">Checkout</a>
        </div>
      </b-col>
    </b-row>
  </b-container>
</template>

<script>
export default {
  data() {
    return {
      total: 2000000,
      price: 1000000,
      quantity: 2,
    }
  },
}
</script>

<style lang="scss" scoped>
.shopping-cart {
  padding-top: 20px;
  padding-bottom: 40px;
  .cart-table {
    margin-bottom: 20px;
    table {
      width: 100%;
      border: 1px solid #ebebeb;
      tr th {
        font-size: 16px;
        color: #252525;
        font-weight: 500;
        border-bottom: 1px solid #ebebeb;
        text-align: center;
        padding: 18px 0 19px;
        text-transform: uppercase;
        .p-name {
          text-align: left;
        }
      }
      tr td {
        text-align: center;
        padding-bottom: 34px;
        .p-price {
          width: 16%;
        }
        .qua-col {
          width: 16%;
          .quantity {
            display: -webkit-box;
            display: -ms-flexbox;
            display: flex;
            -webkit-box-pack: center;
            -ms-flex-pack: center;
            justify-content: center;
          }
        }
        .total-price {
          width: 12%;
        }
      }
    }
  }
  .proceed-checkout {
    .proceed-btn {
      font-size: 14px;
      font-weight: 700;
      color: #000000;
      background: #ce785c;
      text-transform: uppercase;
      padding: 15px 25px 14px 25px;
      display: block;
      text-align: center;
      text-decoration: none;
    }
    .proceed-btn:hover {
      color: red;
    }
    ul {
      border: 2px solid #ebebeb;
      background: #f3f3f3;
      padding-left: 25px;
      padding-right: 25px;
      padding-top: 16px;
      padding-bottom: 20px;
      font-family: cursive;
      li {
        list-style: none;
        font-size: 16px;
        font-weight: 700;
        color: #252525;
        text-transform: uppercase;
        overflow: hidden;
        .cart-total {
          padding-top: 10px;
        }
        span {
          float: right;
          color: red;
        }
      }
    }
  }
}
@media screen and (max-width: 600px) {
  .shopping-cart {
    .cart-table {
      table {
        tr th {
          font-size: 10px;
        }
      }
    }
    .proceed-checkout {
      .proceed-btn {
        font-size: 10px;
      }
      ul {
        li {
          font-size: 10px;
        }
      }
    }
  }
  * {
    font-size: 8px;
  }
}
</style>
