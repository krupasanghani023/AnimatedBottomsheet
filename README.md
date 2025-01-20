# Animated bottom bar

AnimatedBottomBar is bottom navigation bar with customizable bubble like tabs

![](media/demo.gif)

## Usage
 
```xml
    <com.example.animatedbottombar.bubbleTabBarView.BubbleTabBar
               android:id="@+id/bubbleTabBar"
               android:layout_width="match_parent"
               android:layout_height="wrap_content"
               android:background="#FFF"
               android:elevation="16dp"
               android:padding="7dp"
               app:bubbletab_menuResource="@menu/list"
               app:bubbletab_custom_font="@font/opensans"
               app:bubbletab_disabled_icon_color="@color/colorPrimaryDark"
               app:bubbletab_horizontal_padding="20dp"
               app:bubbletab_icon_size="20dp"
               app:bubbletab_title_size="16sp"
               app:bubbletab_icon_padding="5sp"
               app:bubbletab_vertical_padding="10dp"
               app:bubbletab_tab_corner_radius="25dp">
       </com.example.animatedbottombar.bubbleTabBarView.BubbleTabBar>
```
or just use
```xml
    <com.example.animatedbottombar.bubbleTabBarView.BubbleTabBar
               android:id="@+id/bubbleTabBar"
               android:layout_width="match_parent"
               android:layout_height="wrap_content"
               android:padding="7dp"
               app:bubbletab_menuResource="@menu/list">
       </com.example.animatedbottombar.bubbleTabBarView.BubbleTabBar>
```
Inflate menu list
```xml
<menu xmlns:android="http://schemas.android.com/apk/res/android">
    <item
        android:id="@+id/home"
        android:icon="@drawable/baseline_home_24"
        android:title="Home"
        android:checked="true"
        android:color="@color/white"/>

    <item
        android:id="@+id/search"
        android:icon="@drawable/baseline_search_24"
        android:title="Search"
        android:color="@color/white"/>

    <item
        android:id="@+id/profile"
        android:icon="@drawable/baseline_supervised_user_circle_24"
        android:title="Profile"
        android:color="@color/white"/>

</menu>
            
```

Add onclick listener 

```kotlin
   bubbleTabBar.addBubbLeListener(object : OnBubbleClickListener{
               override fun onBubbleClick(id: Int) {
                   
               }
           })
```
### Connect with components like [ViewPager], [ViewPager2] and [NavController]
#### Setup ViewPager to BubbleTabBar

```kotlin

    viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                bubbleTabBar.setSelected(position, false)
            }

            override fun onPageScrollStateChanged(state: Int) {
            }
        })
   
```

#### Setup ViewPager2 to BubbleTabBar

```kotlin

    viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                               override fun onPageSelected(position: Int) {
                                   super.onPageSelected(position)
                                   bubbleTabBar.setSelected(position)
                               }
                           })

```

#### Setup NavController to BubbleTabBar

*onNavDestinationSelected

```kotlin

    bubbleTabBar.addBubbleListener { id ->
                bubbleTabBar.onNavDestinationSelected(id, navController)
            }
    navController.addOnDestinationChangedListener { _, destination, _ ->
                setSelectedWithId(destination.id, false)
            }
    

```