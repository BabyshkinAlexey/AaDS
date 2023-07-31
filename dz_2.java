import java.util.Iterator;

public class dz_2 {
    public static void main(String[] args) {
        SingleLinkList<Contact> contactList = new SingleLinkList<>();

        contactList.addToEnd(new Contact(1, "aaaaaaaaaaaaaa", "+1111"));
        contactList.addToEnd(new Contact(2, "bbbbbbbbbbbbbb", "+2222"));
        contactList.addToEnd(new Contact(3, "cccccccccccccc", "+3333"));
        contactList.addToEnd(new Contact(4, "dddddddddddddd", "+4444"));
        contactList.addToEnd(new Contact(5, "eeeeeeeeeeeeee", "+5555"));

        for (Contact contact : contactList) {
            System.out.println(contact);
        }

        contactList.reverse();

        System.out.println("-------------------------------------------------------");

        for (Contact contact : contactList) {
            System.out.println(contact);
        }
    }

    static class Contact {
        int id;
        String name;
        String phone;

        public Contact(int id, String name, String phone) {
            this.id = id;
            this.name = name;
            this.phone = phone;
        }

        @Override
        public String toString() {
            return "Contact {" +
                    "id: " + id +
                    "; name = " + name + 
                    "; phone = " + phone + 
                    '}';
        }
    }

    public static class SingleLinkList<T> implements Iterable<T> {

        ListItem<T> head;
        ListItem<T> tail;

        @Override
        public Iterator<T> iterator() {
            return new Iterator<T>() {
                ListItem<T> current = head;

                @Override
                public boolean hasNext() {
                    return current != null;
                }

                @Override
                public T next() {
                    T data = current.data;
                    current = current.next;
                    return data;
                }
            };
        }

        private static class ListItem<T> {
            T data;
            ListItem<T> next;
        }

        public boolean isEmpty() {
            return head == null;
        }

        public void addToEnd(T item) {
            ListItem<T> newItem = new ListItem<>();
            newItem.data = item;
            if (isEmpty()) {
                head = newItem;
                tail = newItem;
            } else {
                tail.next = newItem;
                tail = newItem;
            }
        }

        public void reverse() {
            if (!isEmpty() && head.next != null) {
                tail = head;
                ListItem<T> current = head.next;
                head.next = null;
                while (current != null) {
                    ListItem<T> next = current.next;
                    current.next = head;
                    head = current;
                    current = next;
                }
            }
        }
    }
}