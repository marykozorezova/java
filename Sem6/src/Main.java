public class Main {
    public static void main(String[] args) {
        Set<NoteBook> noteBookSet = GetData();
        for (NoteBook noteBook : noteBookSet) {
            System.out.println(NoteBook);
        }
        Map<NoteBook.FilterCriteria, Object> filter = CreateFilterCriteria();
        System.out.println("Фильтр по критериям: " + filter);
        Set<NoteBook> filteredNoteBook = new HashSet<>();
        for (NoteBook noteBook : noteBookSet)
            if (noteBook.CheckCriteria(filter)) filteredNoteBook.add(noteBook);
        if (!filteredNoteBook.isEmpty()) for (NoteBook noteBook : filteredNoteBook)
            System.out.println(NoteBook);
        else System.out.println("Ничего не найдено.");
    }

    public static Set<NoteBook> GetData() {
        Set<NoteBook> noteBookSet = new HashSet<>();
        noteBookSet.add(new NoteBook("HONOR", "white", "Windows 11", 16, 512));
        noteBookSet.add(new NoteBook("Lenovo", "black", "Windows 11", 4, 512));
        noteBookSet.add(new NoteBook("ASUS", "darkgrey", "Windows 11", 16, 512));
        noteBookSet.add(new NoteBook("HP", "silver", "Windows 11", 16, 512));
        noteBookSet.add(new NoteBook("Xiaomi", "silver", "Windows 11", 8, 256));
        noteBookSet.add(new NoteBook("ASUS", "darkgrey", "Linux", 16, 256));
        noteBookSet.add(new NoteBook("Lenovo", "white", "Linux", 8, 512));
        noteBookSet.add(new NoteBook("ASUS", "darkgrey", "Windows 11", 4, 256));
        noteBookSet.add(new NoteBook("Dell", "darkgrey", "Linux", 4, 256));
        noteBookSet.add(new NoteBook("ASUS", "purple", "Linux", 8, 512));
        return noteBookSet;
    }

    public static Map<NoteBook.FilterCriteria, Object> CreateFilterCriteria() {
        Scanner scanner = new Scanner(System.in);
        Map<NoteBook.FilterCriteria, Object> criteria = new HashMap<>();
        while (true) {
            System.out.println("Добавлены критерии: " + criteria);
            PrintMenu();
            System.out.print("> ");
            int command = scanner.nextInt();
            scanner.nextLine();
            switch (command) {
                case 0:
                    scanner.close();
                    return criteria;
                case 1:
                    System.out.print("Введите производителя: ");
                    criteria.put(NoteBook.FilterCriteria.VENDOR, scanner.nextLine());
                    break;
                case 2:
                    System.out.print("Введите цвет: ");
                    criteria.put(NoteBook.FilterCriteria.COLOR, scanner.nextLine());
                    break;
                case 3:
                    System.out.print("Введите операционнцю систему: ");
                    criteria.put(NoteBook.FilterCriteria.OS, scanner.nextLine());
                    break;
                case 4:
                    System.out.print("Введите минимальный объем оперативной памяти в гигабайтах: ");
                    criteria.put(NoteBook.FilterCriteria.RAM, scanner.nextInt());
                    break;
                case 5:
                    System.out.print("Введите минимальную ёмкость жесткого диска: ");
                    criteria.put(NoteBook.FilterCriteria.STORAGE, scanner.nextInt());
                    break;
                default:
                    break;
            }
        }
    }

    public static void PrintMenu() {
        System.out.println("""
                Какие критерии для фильтрации добавить?
                1 - Производитель
                2 - Цвет
                3 - Операционная система
                4 - Минимальный объем оперативной памяти
                5 - Минимальная емкость жесткого диска\s
                0 - Закончить выбор""");
    }
}



