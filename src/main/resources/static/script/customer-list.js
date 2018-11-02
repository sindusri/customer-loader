angular.
  module('customer').
  component('customerList', {
    template:
        '<ul>' +
          '<li ng-repeat="customer in $ctrl.customers">' +
            '<span>{{customer.firstName}}</span>' +
          '</li>' +
        '</ul>',
    controller:  ['$http', function customerListController($http) {
     var self = this;
        $http.get('customers').then(function(response) {
          self.customers = response.data;
        });
    }
    ]
  });