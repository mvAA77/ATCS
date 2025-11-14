from linkedlist import LinkedList

class Queue:
    def __init__(self):
        self.queue = LinkedList()

    def offer(self, elem):
        self.queue.add(elem)

    def poll(self):
        if self.queue.isEmpty():
            return None
        return self.queue.remove(0)

    def peek(self):
        if self.queue.isEmpty():
            return None
        return self.queue.get(0)

    def isEmpty(self):
        return self.queue.isEmpty()

    def size(self):
        return self.queue.size()
