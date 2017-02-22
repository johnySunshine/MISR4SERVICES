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
        this.$avatarWrapper = $element.find('.avatar-wrapper');
        this.$avatarPreview = $element.find('.img-preview');
        this.$avatarData = $element.find('.avatar-data');
        this.$avatarSrc = $element.find('.avatar-src');
        this.$amForm = $element.find('.am-form');
        this.$insertPoster = $element.find('.insertPoster');
        this.$16x9 = $element.find('.16x9');
        this.$5x7 = $element.find('.5x7');
        this.$1x1 = $element.find('.1x1');
        this.$any = $element.find('.any');
        this.$avatarForm = $element.find('.avatar-form');
        this.$avatarInput = $element.find('.avatar-input');
        this.$avatar16x9 = $element.find('.avatar-16x9');
        this.$avatarBody = $element.find('.avatar-body');
        this.init();
    };
    var cropperMap = {
        aspectRatio: 16 / 9,
        preview: $('#crop-avatar').find('.img-preview').selector,
        crop: function (e) {
            var json = [
                '{"x":' + e.x,
                '"y":' + e.y,
                '"height":' + e.height,
                '"width":' + e.width,
                '"rotate":' + e.rotate + '}'
            ].join();
            $('#crop-avatar').find('.avatar-data').val(json);
        }
    };
    CropperAvatar.prototype = {
        support: {
            fileList: !!$('<input type="file">').prop('files'),
            blobURLs: !!window.URL && URL.createObjectURL,
            formData: !!window.FormData
        },
        init: function () {
            this.support.datauri = this.support.fileList && this.support.blobURLs;
            this.addListener();
        },
        addListener: function () {
            this.$avatarInput.on('change', $.proxy(this.change, this));
            this.$16x9.on('click', $.proxy(this.changeSizeOne, this));
            this.$5x7.on('click', $.proxy(this.changeSizeTwo, this));
            this.$1x1.on('click', $.proxy(this.changeSizeThree, this));
            this.$any.on('click', $.proxy(this.changeSizeFour, this));
            this.$insertPoster.on('click', $.proxy(this.insertPoster, this));
        },
        changeSizeOne: function () {
            this.destroyCropper();
            this.__starCropper(16 / 9);
        },

        changeSizeTwo: function () {
            this.destroyCropper();
            this.__starCropper(5 / 7);
        },

        changeSizeThree: function () {
            this.destroyCropper();
            this.__starCropper(1);
        },

        changeSizeFour: function () {
            this.destroyCropper();
            this.__starCropper('NAN');
        },

        insertPoster: function () {
            var $avaData = $('#crop-avatar').find('.avatar-data').val();
            var avaDataMap = JSON.parse($avaData);
            var avatarInfo = {
                avatarSrc: '',
                avatarOption: '',
                avatarFile: '',
                offsetX: parseInt(avaDataMap.x),
                offsetY: parseInt(avaDataMap.y),
                avatarWidth: parseInt(avaDataMap.width),
                avatarHeight: parseInt(avaDataMap.height),
                avatarIsCut: true
            };
            this.change(avatarInfo, true);
        },

        submit: function () {
            if (!this.$avatarSrc.val() && !this.$avatarInput.val()) {
                return false;
            }
            if (this.support.formData) {
                this.ajaxUpload();
                return false;
            }
        },

        ajaxUpload: function () {


        },
        change: function (avatarInfo, isCutChange) {
            var _this = this;
            var bathPath = window.location.protocol + '//' + window.location.host;
            $.ajaxFileUpload({
                url: bathPath + '/Images/ImagesUpload',
                secureuri: false,
                fileElementId: 'avatarInput',
                dataType: 'json',
                data: avatarInfo,
                success: function (data, status) {
                    if (status === 'success') {
                        var avatar = data;
                        var avatarSrc = avatar.avatarFilePath.split('\\')[0];
                        if (!isCutChange) {
                            if (_this.isImageFile(avatar.avatarName)) {
                                _this.url = bathPath + '/' + avatarSrc + '/' + avatar.avatarName;
                                _this.startCropper()
                            }
                        } else {
                            var imagesSrc = bathPath + '/' + avatarSrc + '/' + avatar.avatarName;
                            _this.imgAppendToGroupFrom(cropperMap.aspectRatio, imagesSrc, avatar.avatarName);
                        }

                    } else {
                        alert('上传图片错误')
                    }
                },
                error: function (data, status, e) {
                    alert('服务端错误')
                }
            });
        },
        imgAppendToGroupFrom: function (imagesType, imagesPath, avatarName) {
            var _this = this;
            switch (imagesType) {
                case parseFloat(16 / 9):
                    _this.__appendDom('16x9', imagesPath, avatarName);
                    break;
                case parseFloat(5 / 7):
                    _this.__appendDom('5x7', imagesPath, avatarName);
                    break;
                case 1:
                    _this.__appendDom('1x1', imagesPath, avatarName);
                    break;
                default:
                    _this.__appendDom('any', imagesPath, avatarName);

            }
        },
        __appendDom: function (imagesType, imagesPath, avatarName) {
            var $tablebody = $('.am-table-tbody');
            var $Dom = '<tr class="gradeX">' +
                '<td>' +
                '<img src="' + imagesPath + '" class="tpl-table-line-img" alt="">' +
                '</td>' +
                '<td class="am-text-middle">' + imagesType + '</td>' +
                '<td class="am-text-middle">' + avatarName + '</td>' +
                '</tr>';
            $tablebody.append($Dom);
        },

        startCropper: function () {
            if (this.active) {
                this.$img.cropper('replace', this.url);
            } else {
                this.__starCropper(1);
            }
        },

        __starCropper: function (sizeRatio) {
            this.$img = $('<img src="' + this.url + '">');
            this.$avatarWrapper.empty().html(this.$img);
            cropperMap.aspectRatio = sizeRatio;
            this.$img.cropper(cropperMap);
            this.active = true;
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
