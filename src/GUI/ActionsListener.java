package GUI;

import javax.swing.*;

public interface ActionsListener {
    void onAdd(String text);

    void onAddById(String text, int index);

    void onRemove(int index);

    void onSort();

    void onSave();

    void onLoad();

    DefaultListModel<Object> getListModel();

    void onSelectType(String type);
}
