public class Event extends Task {
    private String from;
    private String to;

    public Event(String command, String from, String to) {
        super(command);
        this.from = from;
        this.to = to;
    }

    public static void makeEvent(ListOfTasks list, String command) {
        try {
            String[] words = command.trim().split("\\s+", 2);
            if (words.length > 1 && command.contains("/from") && command.contains("/to")) {
                String[] parts = words[1].split("/from", 2);
                String[] fromTo = parts[1].split("/to", 2);
                String from = fromTo[0].trim();
                String to   = fromTo[1].trim();
                Event event = new Event(parts[0].trim(), from, to);
                list.setTask(event);
                new Display(event).addTask(list);
            } else {
                throw new EventException("JARVIS, show them how it's done.\n\tevent <event> /from <start> /to <end>");
            }
        } catch (TonyException e) {
            System.out.println(e.getMessage());
        }

    }

    public String toString() {
        return "[E]" + super.toString() + " (from: " + this.from + " to: " + this.to + ")";
    }

    public String toDataFormat() {
        return "E | " + (doneStatus() ? 1 : 0) + " | " + this.command + " | " + this.from + "-" + this.to;
    }
}
