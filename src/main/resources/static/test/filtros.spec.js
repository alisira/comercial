describe("A suite is just a function", function() {
  var a;
  var b;

  it("and so is a spec", function() {
    a = false;

    expect(a).toBe(true);
  });
});
    