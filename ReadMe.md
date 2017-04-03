# View Lift Challenge

#### Problem  
Please use this feed  <http://snagfilms.com/feeds> and use Android and render that in  a UI. Once the films are loaded, use the player from feed and play the video. Please try it out on your computer screen and let me know your approach.

#### Approach  
##### Architecture: 
MVP  
#####Libraries used:
Retrofit  (Network calls)  
RxJava  (Asynchronous Communication)  
Butterknife  (View Binding)  
ExoPlayer  (Asynchronous MediaPlayer)  
Glide  (Image Loading and Caching)  
Dagger  (Dependency Injection)  
SimpleXMLConverter (XML to Pojos converter)


##### Steps
1. Create a Retrofit helper class to create functions to return a retrofit instance and observables required through retrofit helper interface for different verbs.
2. Import recyclerView library and create XML for each item in the recyclerView
3. Instantiate the list of model objects by obtaining the result back from the observable.
4. Pass the list to the recyclerView adapter to bind each view.*
5. Bind each item using the model object fields to viewHolder class elements.
6. In a case of details activity, pass the model object through intent as a serializable/parcelable extra to bind views.

*Filtering results is done in Java by reinitializing the list of model objects for the adapter. 


#### Application
##### Activities
1. Splash Activity: To show ViewLift logo  
2. VideoList Activity: Contains search box to filter results and recyclerView with list of films from given URL.
3. VideoDetail Activity: Contains ExoPlayer to play the video and other video details.

#### Utility
1. VideoListAdapter: RecyclerView adapter for VideoListActivity.
2. RetrofitHelper: Retrofit factory class and interface for network calls.

#### Additional Features
1. Search list: The list is sorted according to the string entered for titles.
2. Sort: List is sorted for *FilmType* (Trailer/Full film)
