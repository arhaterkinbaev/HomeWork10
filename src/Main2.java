import java.util.ArrayList;
import java.util.List;

abstract class FileSystemComponent {
    protected String name;

    public FileSystemComponent(String name) {
        this.name = name;
    }

    public abstract void display();
    public abstract int getSize();
}

class File extends FileSystemComponent {
    private int size;

    public File(String name, int size) {
        super(name);
        this.size = size;
    }

    @Override
    public void display() {
        System.out.println("Файл: " + name + " (Размер: " + size + " KB)");
    }

    @Override
    public int getSize() {
        return size;
    }
}

class Directory extends FileSystemComponent {
    private List<FileSystemComponent> components = new ArrayList<>();

    public Directory(String name) {
        super(name);
    }

    public void addComponent(FileSystemComponent component) {
        if (!components.contains(component)) {
            components.add(component);
        } else {
            System.out.println("Компонент уже существует в папке: " + name);
        }
    }

    public void removeComponent(FileSystemComponent component) {
        if (components.contains(component)) {
            components.remove(component);
        } else {
            System.out.println("Компонент не найден в папке: " + name);
        }
    }

    @Override
    public void display() {
        System.out.println("Папка: " + name);
        for (FileSystemComponent component : components) {
            component.display();
        }
    }

    @Override
    public int getSize() {
        int totalSize = 0;
        for (FileSystemComponent component : components) {
            totalSize += component.getSize();
        }
        return totalSize;
    }
}

public class Main2 {
    public static void main(String[] args) {
        File file1 = new File("file1.txt", 100);
        File file2 = new File("file2.jpg", 200);
        File file3 = new File("file3.mp3", 300);

        Directory folder1 = new Directory("Folder1");
        Directory folder2 = new Directory("Folder2");
        Directory root = new Directory("Root");

        folder1.addComponent(file1);
        folder1.addComponent(file2);
        folder2.addComponent(file3);
        root.addComponent(folder1);
        root.addComponent(folder2);

        System.out.println("Содержимое файловой системы:");
        root.display();
        System.out.println("Общий размер: " + root.getSize() + " KB");
    }
}
