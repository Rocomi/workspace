let cart = [];

function addToCart(product, price) {
    cart.push({ product, price });
    updateCart();
}

function updateCart() {
    const cartItems = document.getElementById("cart-items");
    cartItems.innerHTML = '';
    if (cart.length === 0) {
        cartItems.innerHTML = "<p>No items in the cart yet.</p>";
    } else {
        cart.forEach(item => {
            const cartItem = document.createElement("p");
            cartItem.textContent = `${item.product} - $${item.price.toFixed(2)}`;
            cartItems.appendChild(cartItem);
        });
    }
    updateTotal();
}

function updateTotal() {
    const totalDiv = document.getElementById("total");
    const total = cart.reduce((sum, item) => sum + item.price, 0);
    totalDiv.innerHTML = `<h3>Total: $${total.toFixed(2)}</h3>`;
}

document.getElementById("contactForm").addEventListener("submit", function(event){
    event.preventDefault();
    const name = document.getElementById("name").value;
    const email = document.getElementById("email").value;
    const message = document.getElementById("message").value;

    if (name && email && message) {
        alert(`Thank you, ${name}. Your message has been sent.`);
        document.getElementById("contactForm").reset();
    } else {
        alert("Please fill out all fields.");
    }
});

function scrollToProducts() {
    document.getElementById("products").scrollIntoView({ behavior: "smooth" });
}
