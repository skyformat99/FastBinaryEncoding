//
// Created by Ivan Shynkarenka on 15.05.2018
//

#include "test.h"

#include "../proto/proto.h"
#include "../proto/test.h"

class MySender : public FBE::proto::Sender<FBE::WriteBuffer>
{
protected:
    size_t onSend(const void* data, size_t size) override
    {
        // Send nothing...
        return 0;
    }
};

class MyReceiver : public FBE::proto::Receiver<FBE::WriteBuffer>
{
public:
    MyReceiver() : _order(false), _balance(false), _account(false) {}

    bool check() const { return _order && _balance && _account; }

protected:
    void onReceive(const proto::Order& value) override { _order = true; }
    void onReceive(const proto::Balance& value) override { _balance = true; }
    void onReceive(const proto::Account& value) override { _account = true; }

private:
    bool _order;
    bool _balance;
    bool _account;
};

bool SendAndReceive(size_t index)
{
    MySender sender;

    // Create and send a new order
    proto::Order order = { 1, "EURUSD", proto::OrderSide::buy, proto::OrderType::market, 1.23456, 1000.0 };
    sender.send(order);

    // Create and send a new balance wallet
    proto::Balance balance = { "USD", 1000.0 };
    sender.send(balance);

    // Create and send a new account with some orders
    proto::Account account = { 1, "Test", proto::State::good, { "USD", 1000.0 }, std::make_optional<proto::Balance>({ "EUR", 100.0 }), {} };
    account.orders.emplace_back(1, "EURUSD", proto::OrderSide::buy, proto::OrderType::market, 1.23456, 1000.0);
    account.orders.emplace_back(2, "EURUSD", proto::OrderSide::sell, proto::OrderType::limit, 1.0, 100.0);
    account.orders.emplace_back(3, "EURUSD", proto::OrderSide::buy, proto::OrderType::stop, 1.5, 10.0);
    sender.send(account);

    MyReceiver receiver;

    // Receive data from the sender
    index %= sender.buffer().size();
    receiver.receive(sender.buffer().data(), index);
    receiver.receive(sender.buffer().data() + index, sender.buffer().size() - index);
    return receiver.check();
}

TEST_CASE("Send & Receive", "[FBE]")
{
    for (size_t i = 0; i < 1000; ++i)
        REQUIRE(SendAndReceive(i));
}
