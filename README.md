# Various Android-projects

A collection of Android-projects, which are too small to create a single-repository for each.

## Android Studio Key-Combinations
- Select a textual field, then ctrl + cmd + space => Opens overlay-window with symbols.
- Delete a line: cmd + <-
- Override methods: ctrl + o
- Duplicate a line: cmd + d
- Show recently used files: cmd + e
- Start app in debug-mode: ctrl + d

## Miscellaneous
- "Help" => "Find Action ..." => Type substring of action, you like to execute.

- Avoid that the first list-item of a Recycler View becomes overlay by the top-toolbar.
`<androidx.recyclerview.widget.RecyclerView

        app:layout_behavior="@string/appbar_scrolling_view_behavior"
        ... />`
