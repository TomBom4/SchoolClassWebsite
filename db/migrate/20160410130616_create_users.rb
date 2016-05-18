class CreateUsers < ActiveRecord::Migration
  def change
    create_table :users do |t|
      t.string :name
      t.string :password

      t.timestamps null: false
    end
  end
  add_index :users, :name, :password
end
