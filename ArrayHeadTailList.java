import java.util.Arrays;

public class ArrayHeadTailList<T> implements HeadTailListInterface<T>  {

	private T[] listArray;
	private int numberOfElements;
	
	   
	   public ArrayHeadTailList(int initialCapacity) {
		   
		   @SuppressWarnings("unchecked")
		   T[] tempList = (T[])new Object[initialCapacity];
		   listArray = tempList;
		   numberOfElements = 0;
		   
	   }
	   
	   public void addFront(T newEntry) {
		   isThereSpaceToAdd ();
		   
		   for (int i = numberOfElements -1; i >= 0 ; i-- ) {
			   listArray[i + 1] = listArray[i];
		   }
		   listArray[0] = newEntry;
		   numberOfElements++;
	   }
	   
	   public void addBack(T newEntry) {
		   isThereSpaceToAdd ();
		   
		   listArray[numberOfElements] = newEntry;
		   numberOfElements++;
	   }
	   
	   public T removeFront() {
		   T elementToRemove = null;
		   
		  if (!isEmpty()) {
			  elementToRemove = listArray[0];
			  
			  for(int i = 0; i < numberOfElements - 1; i++) {
				  listArray[i] = listArray[i+1];
			  }
			  numberOfElements--;  
		  }
		  return elementToRemove;
		   
	   }
	   
	   public T removeBack() {
		   T elementToRemove = null;
		   
		   if(!isEmpty()) {
			   elementToRemove =listArray[(numberOfElements - 1)];
			   listArray[(numberOfElements - 1)] = null;
			   numberOfElements--;
		   }
		   return elementToRemove;
	   }
	   
	   public void clear() {
		   
		   for (int i = 0; i < listArray.length; i++) {
			   listArray[i] = null;
		   }
		   numberOfElements = 0;
	   }
	   
	   public T getEntry(int givenPosition) {
		   if(givenPosition >= 0 && givenPosition < listArray.length) {
			   return listArray[givenPosition];
		   }
		   else {
			   return null;
		   }
	   }
	   
	   public void display() {
		   
		  System.out.print(numberOfElements + " elements; capacity = " + listArray.length );
		  if(!isEmpty()) {
			  System.out.print("\t[");
		  }
		   for (int i = 0; i < numberOfElements; i++) { 
			   System.out.print(listArray[i].toString()); 
			   if(i < numberOfElements -1) {
				   System.out.print(", "); 
			   }
		   }  
		   if(!isEmpty()) {
				  System.out.print("]");
			  }
	   }
	   
	   public int indexOf(T anEntry) {
		   for(int i = 0; i < numberOfElements; i++) {
			   if(listArray[i].equals(anEntry)) {
				   return i;
			   }
		   }
		   return -1;
	   }
	   
	   public int lastIndexOf(T anEntry) {
		   for(int i = numberOfElements - 1; i >= 0; i--) {
			   if(listArray[i].equals(anEntry)) {
				   return i;
			   }
		   }
		   return -1;
	   }
	   
	   public boolean contains(T anEntry) {
		   for(int i = 0; i <  numberOfElements ; i++) {
			   if(listArray[i].equals(anEntry)) {
				   return true;
			   }
		   }
		   return false;
	   }
	   
	   public int size() {
		   return numberOfElements;
	   }
	   
	   
	   public boolean isEmpty() {
		   return numberOfElements == 0;
	   }
	   
	   private void isThereSpaceToAdd () {
		  int currentCapacity = listArray.length ;
		   if (numberOfElements == currentCapacity) {
			   int doubleCapacity = 2 * (listArray.length);
			   listArray = Arrays.copyOf(listArray, doubleCapacity);
			   
		   }
	   }
	   
}
	   
	  
