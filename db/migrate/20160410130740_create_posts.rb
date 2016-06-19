class CreatePosts < ActiveRecord::Migration
  def change
    create_table :posts do |t|
      t.string :title
      t.text :text
      t.integer :forum_thread_id
      t.integer :user_id

      t.timestamps null: false
    end
  end
end
