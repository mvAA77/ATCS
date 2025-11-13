from node import Node

class LinkedList:
    
    header = None
    tail = None
    count = 0
    
    ##def __init__(self):

    
    def add(elem):
        newNode = Node(elem)
        if (isEmpty()):
            header = newNode
            tail = newNode
        else:
            tail.nextNode = newNode
            tail = newNode

        count+= 1
        
    
    def remove(index):
        if (index < 0 or index >= count):
            print("Index: " + index + ", Size: " + count)
        
        removedValue
        
        if (index == 0):
            removedValue = header.getValue()
            header = header.nextNode;
            if (header == None):
                tail = None;
        else:
            current = header
            for i in range(5):
                current = current.nextNode
            
            
            removedValue = current.nextNode.getValue()
            
            if (current.nextNode == tail):
                tail = current

            current.nextNode = current.nextNode.nextNode
        
        count-= 1
        return removedValue

    
    def get(index):
        if (index < 0 or index >= count):
            print("Index: " + index + ", Size: " + count)
        
        current = header

        for i in range(index):
            current = current.nextNode
        
        return current.getValue()

    
    def isEmpty():
        return count == 0
    
    def size():
        return count
    
    def output():
        current = header
        print("LinkedList: ")
        while (current != None):
            print(current.getValue() + " ")
            current = current.nextNode

        print()
    
    def contains(elem):
        current = header
        index = 0
        while (current != None):
            if (current.getValue().equals(elem)):
                return index
            
            current = current.nextNode
            index+= 1
        
        return -1
    
    def removeFirst(elem):
        if (isEmpty()):
            return false
        
        
        if (header.getValue().equals(elem)):
            remove(0)
            return true
        
        current = header
        while (current.nextNode != None):
            if (current.nextNode.getValue().equals(elem)):
                if (current.nextNode == tail):
                    tail = current
                
                current.nextNode = current.nextNode.nextNode
                count -= 1
                return True
            
            current = current.nextNode
        
        
        return False;
    
    
    def insert(pos, elem):
        if (pos < 0 or pos > count):
            print("Index: " + pos + ", Size: " + count)
        
        
        if (pos == count):
            add(elem)
            return
        
        newNode = Node(elem)
        
        if (pos == 0):
            newNode.nextNode = header
            header = newNode
            if (tail == None):
                tail = newNode
        else:
            current = header
            for i in range(pos - 1):
                current = current.nextNode
            newNode.nextNode = current.nextNode
            current.nextNode = newNode
        
        count+= 1
    