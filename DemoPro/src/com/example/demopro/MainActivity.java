package com.example.demopro;

import com.terlici.dragndroplist.DragNDropCursorAdapter;
import com.terlici.dragndroplist.DragNDropListView;

import android.app.Activity;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.Bundle;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		DragNDropListView list = (DragNDropListView) findViewById(android.R.id.list);

		String[] columns = new String[] { "_id", "text", "description" };
		MatrixCursor matrixCursor= new MatrixCursor(columns);
		startManagingCursor(matrixCursor);

		matrixCursor.addRow(new Object[] { 1, "Item A", "...." });
		matrixCursor.addRow(new Object[] { 2, "Item B", "...." });
		matrixCursor.addRow(new Object[] { 3, "Item C", "...." });
		matrixCursor.addRow(new Object[] { 4, "Item D", "...." });
		
		DragNDropCursorAdapter adapter = new DragNDropCursorAdapter(MainActivity.this,
				R.layout.row, matrixCursor, new String[] { "text" },
				new int[] { R.id.text }, R.id.handler);

		list.setDragNDropAdapter(adapter);

	}

}
