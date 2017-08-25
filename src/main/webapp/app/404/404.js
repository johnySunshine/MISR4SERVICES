/**
 * Created by Fantasy on 2017/8/20.
 */
var viewModel = {
    reBackHome: function () {
        location.href = BathPath() + "/";
    }
};
ko.applyBindings(viewModel);