<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class CreateColorsTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('colors', function (Blueprint $table) {
            $table->integer('id', true);
            $table->string('name', 15);
            $table->string('url', 20);
            $table->string('image', 100);


            $table->timestamps();
        });
        Schema::table('colors', function (Blueprint $table) {

            $table->integer('products_id');

            $table->foreign('products_id')->references('id')->on('products');

            $table->integer('create_by');
            $table->integer('update_by');

            $table->foreign('create_by')->references('id')->on('users');
            $table->foreign('update_by')->references('id')->on('users');
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('colors');
    }
}
