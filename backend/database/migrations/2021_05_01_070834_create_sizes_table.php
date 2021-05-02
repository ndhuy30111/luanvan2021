<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class CreateSizesTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('sizes', function (Blueprint $table) {
            $table->integer('id', true);;
            $table->string('name', 15);
            $table->integer('amount')->length('5')->default('0');

            $table->timestamps();
        });
        Schema::table('sizes', function (Blueprint $table) {

            $table->integer('colors_id');

            $table->foreign('colors_id')->references('id')->on('colors');

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
        Schema::dropIfExists('sizes');
    }
}
