
# Android Recycler ViewPager
The library is a RecyclerView-based implementation of a scrollable list, where current item is centered and can be changed using swipes. It is similar to a ViewPager
[![](https://jitpack.io/v/seifhjh/RecyclerScrollViewPager.svg)](https://jitpack.io/#seifhjh/RecyclerScrollViewPager)
# ScreenShot
[![N|Solid](https://raw.githubusercontent.com/seifhjh/RecyclerScrollViewPager/master/screenshoot/image.gif)](https://seifhadjhassen.net/img/upmanager.gif)
# Download
##### Step 1. Add the JitPack repository to your build file 
```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
##### Step 2. Add the dependency
```
dependencies {
	  implementation 'com.github.seifhjh:RecyclerScrollViewPager:1.0.1'
	}
```

# How to use
### XML
``` xml
 <net.seifhadjhassen.recyclerviewpager.RecyclerViewPager
        android:id="@+id/pager"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="20dp"
        app:svp_timeMillis="1000"
        app:svp_colorActiveIndicator="@color/colorPrimary"
        app:svp_colorInactiveIndicator="@color/gray"
        app:svp_runAuto="true">

    </net.seifhadjhassen.recyclerviewpager.RecyclerViewPager>
```

#### JAVA
``` java
 RecyclerViewPager recyclerViewPager=findViewById(R.id.pager);
        // add item from resource

    recyclerViewPager.addItem(new PagerModel(R.drawable.cover1,"Vikings",getApplicationContext()));
    recyclerViewPager.addItem(new PagerModel(R.drawable.cover2,"The nutcracker and the four realms",getApplicationContext()));
    recyclerViewPager.addItem(new PagerModel(R.drawable.cover3,"Flash",getApplicationContext()));
    
    //add item from url
    
    //  recyclerViewPager.addItem(new PagerModel("http://i.imgur.com/DvpvklR.png","Vikings"));
    // don't forget this line
    recyclerViewPager.start();
```
#### Item click event
``` java
recyclerViewPager.setOnItemClickListener(new PagerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(getApplicationContext(),"click pos "+position,Toast.LENGTH_SHORT).show();
            }
        });
```

### Attribute
XML| JAVA| Default|Definition
-------- | ----- | ----- | -----
`app:svp_runAuto="boolean"`| setAutoRun(boolean autoScroll) | false | viewPager auto scrolling
`app:svp_timeMillis="Integer"`| setTime(int millis) | 2000 | set time of scrolling
`app:svp_colorActiveIndicator="Color"`| setColorActiveIndicator(int color) | 0xDE000000 | set color of active indicator
`app:svp_colorInactiveIndicator="Color"`| setColorInactiveIndicator(int color) | 0x33000000 | set color of active indicator


## Full Example
[MainActivity.java](https://github.com/seifhjh/RecyclerScrollViewPager/blob/master/app/src/main/java/net/seifhadjhassen/recyclerscrollviewpager/MainActivity.java)


# Developer
[Seif Hadjhassen - Github](https://github.com/seifhjh)\
[Seif Hadjhassen - Linked In](https://www.linkedin.com/in/seifhadjhassen)\
[Seif Hadjhassen - Facebook](https://www.facebook.com/seif.hajhassen)\
[Seif Hadjhassen - Twitter](https://twitter.com/seifhadjhassen)\
[Seif Hadjhassen - Dribbble](https://dribbble.com/seifhadjhassen)\
[Seif Hadjhassen - Pinterest](https://www.pinterest.com/seifhadjhassen)
# License
```
  Copyright 2019 Seif Hadjhassen

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
   ```
