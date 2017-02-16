/**
 * Created by Fantasy on 2017/2/16.
 */
(function (factory) {
    if (typeof define === 'function' && define.amd) {
        // AMD. Register as anonymous module.
        define(['jquery'], factory);
    } else if (typeof exports === 'object') {
        // Node / CommonJS
        factory(require('jquery'));
    } else {
        // Browser globals.
        factory(jQuery);
    }
})(function ($) {
    var CropperAvatar = function ($element) {
        this.$avatarView = $element.find('.avatar-view');
        this.$avatarInput = $element.find('.avatar-input');
        this.$avatarWrapper = $element.find('.avatar-wrapper');
        this.$avatarPreview = $element.find('.img-preview');
        this.$avatarData = $element.find('.avatar-data');
        this.$avatarSrc = $element.find('.avatar-src');
        this.$16x9 = $element.find('.16x9');
        this.$5x7 = $element.find('.5x7');
        this.$1x1 = $element.find('.1x1');
        this.$any = $element.find('.any');
        this.init();
    };

    CropperAvatar.prototype = {
        support: {
            fileList: !!$('<input type="file">').prop('files'),
            blobURLs: !!window.URL && URL.createObjectURL,
            formData: !!window.FormData
        },
        initCropperMap: function () {
            var _this = this;
            return {
                aspectRatio: 16 / 9,
                preview: this.$avatarPreview.selector,
                crop: function (e) {
                    var json = [
                        '{"x":' + e.x,
                        '"y":' + e.y,
                        '"height":' + e.height,
                        '"width":' + e.width,
                        '"rotate":' + e.rotate + '}'
                    ].join();
                    _this.$avatarData.val(json);
                }
            }
        }
        ,
        init: function () {
            this.support.datauri = this.support.fileList && this.support.blobURLs;
            this.addListener();
        },
        addListener: function () {
            this.$avatarInput.on('change', $.proxy(this.inputChange, this));
            this.$16x9.on('click', $.proxy(this.changeSizeOne, this));
            this.$5x7.on('click', $.proxy(this.changeSizeTwo, this));
            this.$1x1.on('click', $.proxy(this.changeSizeThree, this));
            this.$any.on('click', $.proxy(this.changeSizeFour, this));
        },
        changeSizeOne: function () {

        },
        changeSizeTwo: function () {

        },
        changeSizeThree: function () {

        },
        changeSizeFour: function () {

        },
        inputChange: function () {
            var files;
            var file;

            if (this.support.datauri) {
                files = this.$avatarInput.prop('files');
                if (files.length > 0) {
                    file = files[0];

                    if (this.isImageFile(file)) {
                        if (this.url) {
                            URL.revokeObjectURL(this.url); // Revoke the old one
                        }
                        this.url = URL.createObjectURL(file);
                        this.startCropper();
                    }
                }
            } else {
                file = this.$avatarInput.val();

                if (this.isImageFile(file)) {
                    //this.syncUpload();
                }
            }
        },

        startCropper: function () {
            var _this = this;

            if (this.active) {
                this.$img.cropper('replace', this.url);
            } else {
                this.$img = $('<img src="' + this.url + '">');
                this.$avatarWrapper.empty().html(this.$img);
                this.$img.cropper(_this.initCropperMap());
                this.active = true;
            }
        },
        isImageFile: function (file) {
            if (file.type) {
                return /^image\/\w+$/.test(file.type);
            } else {
                return /\.(jpg|jpeg|png|gif)$/.test(file);
            }
        },
        destroyCropper: function () {
            if (this.active) {
                this.$img.cropper('destroy');
                this.active = false;
            }
        }
    };
    $(function () {
        return new CropperAvatar($('#crop-avatar'));
    });
});
