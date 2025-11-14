from node import Node

class LinkedList:
    def __init__(self):
        self.header = None
        self.tail = None
        self.count = 0

    def add(self, elem):
        newNode = Node(elem)
        if self.isEmpty():
            self.header = newNode
            self.tail = newNode
        else:
            self.tail.nextNode = newNode
            self.tail = newNode
        self.count += 1

    def remove(self, index):
        if index < 0 or index >= self.count:
            raise IndexError("Index out of bounds")

        # Removing first element
        if index == 0:
            removedValue = self.header.getValue()
            self.header = self.header.nextNode
            if self.header is None:
                self.tail = None
        else:
            current = self.header
            for _ in range(index - 1):
                current = current.nextNode

            removedValue = current.nextNode.getValue()

            if current.nextNode == self.tail:
                self.tail = current

            current.nextNode = current.nextNode.nextNode

        self.count -= 1
        return removedValue

    def get(self, index):
        if index < 0 or index >= self.count:
            raise IndexError("Index out of bounds")

        current = self.header
        for _ in range(index):
            current = current.nextNode

        return current.getValue()

    def isEmpty(self):
        return self.count == 0

    def size(self):
        return self.count

    def output(self):
        current = self.header
        print("LinkedList:")
        while current is not None:
            print(str(current.getValue()) + " ", end="")
            current = current.nextNode
        print()

    def contains(self, elem):
        current = self.header
        index = 0
        while current is not None:
            if current.getValue() == elem:
                return index
            current = current.nextNode
            index += 1
        return -1

    def removeFirst(self, elem):
        if self.isEmpty():
            return False

        # First element
        if self.header.getValue() == elem:
            self.remove(0)
            return True

        current = self.header
        while current.nextNode is not None:
            if current.nextNode.getValue() == elem:
                if current.nextNode == self.tail:
                    self.tail = current
                current.nextNode = current.nextNode.nextNode
                self.count -= 1
                return True
            current = current.nextNode

        return False

    def insert(self, pos, elem):
        if pos < 0 or pos > self.count:
            raise IndexError("Index out of bounds")

        if pos == self.count:
            self.add(elem)
            return

        newNode = Node(elem)

        if pos == 0:
            newNode.nextNode = self.header
            self.header = newNode
            if self.tail is None:
                self.tail = newNode
        else:
            current = self.header
            for _ in range(pos - 1):
                current = current.nextNode
            newNode.nextNode = current.nextNode
            current.nextNode = newNode

        self.count += 1
