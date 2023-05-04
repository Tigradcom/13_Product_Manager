public class ProductManager {
    private Storage repositories ;

    public ProductManager(Storage repositories) {
        this.repositories = repositories;
    }

    public static void add(Product product) {
        Storage.add(product);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product: repositories.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length+1];
                for (int i =0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp [tmp.length-1] = product;
                result = tmp;
            }
        }
        return result;
    }


    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
    }
}

