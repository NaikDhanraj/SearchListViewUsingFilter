# SearchListViewUsingFilter

-->to implement a search functionality in a listview using filters in your Android application


A listview can be filtered by the user input and is enabled using addTextChangedListener method. 
The search function will filter the listview with a matching string from the user input.
Searching through the listview provides users an easy way to find the information they needed.

-->MainActivity

 An EditText will capture user input as a search parameter and pass it to the filter function in ListViewAdapter.
 
 
 -->ListViewAdapter
 
 The filter class captures the user input text from the MainActivity and refreshes the listview to show a matched result.
