document.addEventListener("DOMContentLoaded", function () {
  const loginForm = document.getElementById("loginForm");
  const addProductForm = document.getElementById("addProductForm");
  const updateProductForm = document.getElementById("updateProductForm");
  const backButton = document.getElementById("backButton");
  const productListAdmin = document.getElementById("productList2");
  const productListUser = document.getElementById("productList1");

  const init = () => {
    if (loginForm) handleAdminLogin();
    if (!localStorage.getItem("isAuthenticated") !== "true" && !loginForm) redirectToLogin();
    if (addProductForm) handleAddProduct();
    if (updateProductForm) handleUpdateProduct();
    if (window.location.pathname.includes("delete.html")) handleDeleteProduct();
    if (backButton) handleBackButton();
    if (productListAdmin) fetchAndDisplayProductsAdmin();
    if (productListUser) fetchAndDisplayProductsUser();
  };

  const handleAdminLogin = () => {
    loginForm.addEventListener("submit", (e) => {
      e.preventDefault();
      const { username, password } = loginForm;
      if (username.value === "admin01" && password.value === "admin123") {
        localStorage.setItem("isAuthenticated", "true");
        window.location.href = "admin.html";
      } else {
        alert("Invalid username or password");
      }
    });
  };

  const redirectToLogin = () => {
    window.location.href = "login.html";
  };

  const handleAddProduct = () => {
    addProductForm.addEventListener("submit", (e) => {
      e.preventDefault();
      const formData = new FormData(addProductForm);
      const product = {
        productName: formData.get("productName"),
        smallPrice: formData.get("smallPrice"),
        regularPrice: formData.get("regularPrice"),
        largePrice: formData.get("largePrice"),
      };
      fetch("/product/add", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(product),
      })
        .then((response) => response.text())
        .then(() => {
          alert("Product added successfully!");
          window.location.href = "admin.html";
        });
    });
  };

  const handleUpdateProduct = () => {
    const params = new URLSearchParams(window.location.search);
    const productId = params.get("id");
    fetch(`/product/Get_With_ID?productId=${productId}`)
      .then((response) => response.json())
      .then((product) => {
        const { productName, smallPrice, regularPrice, largePrice } = product;
        updateProductForm.productId.value = product.productId;
        updateProductForm.productName.value = productName;
        updateProductForm.smallPrice.value = smallPrice;
        updateProductForm.regularPrice.value = regularPrice;
        updateProductForm.largePrice.value = largePrice;
      });

    updateProductForm.addEventListener("submit", (e) => {
      e.preventDefault();
      const formData = new FormData(updateProductForm);
      const updatedProduct = {
        productName: formData.get("productName"),
        smallPrice: formData.get("smallPrice"),
        regularPrice: formData.get("regularPrice"),
        largePrice: formData.get("largePrice"),
      };
      fetch(`/product/update_product/${productId}`, {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(updatedProduct),
      })
        .then((response) => response.text())
        .then(() => {
          alert("Product updated successfully!");
          window.location.href = "admin.html";
        });
    });
  };

  const handleDeleteProduct = () => {
    const params = new URLSearchParams(window.location.search);
    const productId = params.get("id");
    fetch(`/product/Delete_product/${productId}`, { method: "DELETE" }).then(() => {
      alert("Product deleted successfully!");
      window.location.href = "admin.html";
    });
  };

  const handleBackButton = () => {
    backButton.addEventListener("click", () => window.history.back());
  };

  const fetchAndDisplayProductsAdmin = () => {
    fetch("/product/get")
      .then((response) => response.json())
      .then((products) => {
        products.forEach((product) => {
          const { productId, productName, smallPrice, regularPrice, largePrice } = product;
          const li = document.createElement("li");
          li.innerHTML = `<strong>${productName}</strong><br>
                          Small: $${smallPrice}<br>
                          Regular: $${regularPrice}<br>
                          Large: $${largePrice}<br>
                          <button class="updateButton" data-id="${productId}">Update</button>
                          <button class="deleteButton" data-id="${productId}">Delete</button>`;
          productListAdmin.appendChild(li);
        });
      });

    document.addEventListener("click", (event) => {
      const { classList, dataset } = event.target;
      if (classList.contains("updateButton")) window.location.href = `update.html?id=${dataset.id}`;
      if (classList.contains("deleteButton")) window.location.href = `delete.html?id=${dataset.id}`;
    });
  };

  const fetchAndDisplayProductsUser = () => {
    fetch("/product/get")
      .then((response) => response.json())
      .then((products) => {
        products.forEach((product) => {
          const { productName, smallPrice, regularPrice, largePrice } = product;
          const li = document.createElement("li");
          li.innerHTML = `<strong>${productName}</strong><br>
                          Small: $${smallPrice}<br>
                          Regular: $${regularPrice}<br>
                          Large: $${largePrice}`;
          productListUser.appendChild(li);
        });
      });
  };

  init();
});
