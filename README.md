### MVP with a very simple Volley Request to Display a list of users in a recycler view

|||
|--|--|
|`ApiService`  |provides a singleton instance of ApiService and the main api functions|
|`ApiServiceHelper` | interfaces the methods of ApiService|
|`DataManager` | In this example there is only the ApiService as a data source, But in biggger projects this isnt usually so.DataManager combines all the data sources as a single entity|
|`DataManagerHelper` | interfaces all the methods from all data sources : in this case the ApiService only|
|`MainPresenter` | Separates the business logic from the view to keep it clean|
|`ResponseHandler` | simple network callback|
|`UserResponse` | Model class for gson|
|`UserAdapter` | RecyclerView to display list of users.|

