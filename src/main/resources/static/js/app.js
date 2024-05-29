document.addEventListener('DOMContentLoaded', function () {
  const productList = document.getElementById('productList');

  if (productList) {
    fetch('/product/get')
      .then(response => response.json())
      .then(products => {
        products.forEach(product => {
          const li = document.createElement('li');
          li.innerHTML = `${product.productName} - $${product.smallPrice} / $${product.regularPrice} / $${product.largePrice}
                          <a href="update.html?id=${product.productId}">Update</a>
                          <a href="delete.html?id=${product.productId}">Delete</a>`;
          productList.appendChild(li);
        });
      });
  }

  const addProductForm = document.getElementById('addProductForm');
  if (addProductForm) {
    addProductForm.addEventListener('submit', function (e) {
      e.preventDefault();
      const formData = new FormData(addProductForm);
      const product = {
        productName: formData.get('productName'),
        smallPrice: formData.get('smallPrice'),
        regularPrice: formData.get('regularPrice'),
        largePrice: formData.get('largePrice')
      };
      fetch('/product/add', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(product)
      })
        .then(response => response.text())
        .then(data => {
          alert('Product added successfully!');
          window.location.href = 'index.html';
        });
    });
  }

  const updateProductForm = document.getElementById('updateProductForm');
  if (updateProductForm) {
    const params = new URLSearchParams(window.location.search);
    const productId = params.get('id');
    fetch(`/product/Get_With_ID?productId=${productId}`)
      .then(response => response.json())
      .then(product => {
        document.getElementById('productId').value = product.productId;
        document.getElementById('productName').value = product.productName;
        document.getElementById('smallPrice').value = product.smallPrice;
        document.getElementById('regularPrice').value = product.regularPrice;
        document.getElementById('largePrice').value = product.largePrice;
      });

    updateProductForm.addEventListener('submit', function (e) {
      e.preventDefault();
      const formData = new FormData(updateProductForm);
      const updatedProduct = {
        productName: formData.get('productName'),
        smallPrice: formData.get('smallPrice'),
        regularPrice: formData.get('regularPrice'),
        largePrice: formData.get('largePrice')
      };
      fetch(`/product/update_product/${productId}`, {
        method: 'PUT',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(updatedProduct)
      })
        .then(response => response.text())
        .then(data => {
          alert('Product updated successfully!');
          window.location.href = 'index.html';
        });
    });
  }

  if (window.location.pathname.includes('delete.html')) {
    const params = new URLSearchParams(window.location.search);
    const productId = params.get('id');
    fetch(`/product/Delete_product/${productId}`, {
      method: 'DELETE'
    })
      .then(() => {
        alert('Product deleted successfully!');
        window.location.href = 'index.html';
      });
  }
});
