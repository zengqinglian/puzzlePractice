package trees.rb;

import trees.rb.RBTreeNode;

import common.DataStructureInterface;

/**
 * @author Jiri
 */
public class RBTree<Type extends Comparable<Type>> implements DataStructureInterface<Type>
{

    private RBTreeNode<Type> root;

    @Override
    public boolean contains( Type value ) {
        return root != null && root.contains( value );
    }

    @Override
    public DataStructureInterface<Type> add( Type value ) {
        if( root != null ) {
            root = root.add( value );
        } else {
            root = new RBTreeNode<>( value, null, null, null );
            root.balanceInsert();
        }
        assert root == root.root();
//        root.validate();
        return this;
    }

    @Override
    public DataStructureInterface<Type> remove( Type value ) {
        if( root != null ) {
            root = root.remove( value );
        }
        if( root != null ) {
            assert root == root.root();
//            root.validate();
        }
        return this;
    }

    public static class Factory<Type extends Comparable<Type>> implements DataStructureInterface.Factory<Type>
    {

        @Override
        public DataStructureInterface<Type> returnEmptyInstance() {
            return new RBTree<>();
        }
    }
}
