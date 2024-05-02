# Có sự chênh lệch lớn về doanh thu giữa các thành phố không?
# phân tích doanh thu theo thành phố
# Tính tổng doanh thu theo thành phố
city_revenue = df.groupby("City")["Total"].sum()
city_revenue = city_revenue.sort_values(ascending=False)
city_highest_revenue = city_revenue.idxmax()

# Visualize revenue by city
plt.figure(figsize=(10, 6))
colors = ["#FF6F61", "#6B5B95", "#88B04B"]
city_revenue.plot(kind="bar", color=colors, edgecolor="black")
plt.xlabel("City", fontsize=12)
plt.ylabel("Revenue", fontsize=12)
plt.title("Revenue by City", fontsize=14)
plt.xticks(rotation=90)
plt.grid(axis="y", linestyle="--", alpha=0.5)
for i, v in enumerate(city_revenue):
    plt.text(i, v + 10, str(round(v, 2)), ha="center", va="bottom", fontsize=10)

plt.tight_layout()
plt.show()

# Determine the city with the highest revenue
city_highest_revenue = city_revenue.idxmax()
print("The city with the highest revenue is:", city_highest_revenue)
